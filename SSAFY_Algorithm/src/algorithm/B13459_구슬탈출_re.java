package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13459_구슬탈출_re {
    static int N, M;
    static char map[][];
    static int blueR, blueC;
    static int redR, redC;
    static boolean v[][][][];
    static boolean ans;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static boolean flag;

    static class Point {
        int[] red;
        int[] blue;

        Point(int[] red, int[] blue) {
            this.red = red;
            this.blue = blue;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int blue[] = new int[2];
        int red[] = new int[2];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
                if (map[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                }
            }
        }
        v = new boolean[N][M][N][M];
        v[redR][redC][blueR][blueC] = true;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(red, blue));

        System.out.println(wayout(que));
    }

    private static int wayout(Queue<Point> que) {
        int cnt = 0;
        while (!que.isEmpty() && cnt < 10) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point p = que.poll();
                for (int k = 0; k < 4; k++) {
                    int red[] = p.red.clone();
                    int blue[] = p.blue.clone();
                    /*모든 방향으로 기울이면서 이동가능하면 이동위치를 큐에 넣고 다시 4방탐색한다.*/
                    if (search(red, blue, k)) { // 아무 문제 없이 공들이 이동했으면
                        if (map[red[0]][red[1]] == 'O') {
                            return 1;
                        }

                        if (v[red[0]][red[1]][blue[0]][blue[1]])
                            continue;
                        v[red[0]][red[1]][blue[0]][blue[1]] = true;
                        que.add(new Point(red, blue));

                    }
                }
            }
            cnt++;
        }
        return 0;
    }

    private static boolean search(int[] red, int blue[], int dir) {
        boolean redFirst = false;
        if (dir == 0 && red[0] < blue[0])
            redFirst = true;
        if (dir == 1 && red[0] > blue[0])
            redFirst = true;
        if (dir == 2 && red[1] < blue[1])
            redFirst = true;
        if (dir == 3 && red[1] > blue[1])
            redFirst = true;

        int nr = red[0];
        int nc = red[1];
        while (true) {
            nr += dr[dir];
            nc += dc[dir];
            if (map[nr][nc] == '#')
                break;

            red[0] = nr;
            red[1] = nc;
            if (map[nr][nc] == 'O')
                break;
        }

        nr = blue[0];
        nc = blue[1];
        while (true) {
            nr += dr[dir];
            nc += dc[dir];
            if (map[nr][nc] == '#')
                break;
            blue[0] = nr;
            blue[1] = nc;
            if (map[nr][nc] == 'O')
                break;
        }

        if (map[blue[0]][blue[1]] == 'O')
            return false;


        if (red[0] == blue[0] && red[1] == blue[1]) {
            if (dir == 0) {
                if (redFirst) {
                    blue[0]++;
                } else
                    red[0]++;
            } else if (dir == 1) {
                if (redFirst) {
                    blue[0]--;
                } else
                    red[0]--;
            } else if (dir == 2) {
                if (redFirst) {
                    blue[1]++;
                } else
                    red[1]++;
            } else {
                if (redFirst) {
                    blue[1]--;
                } else
                    red[1]--;
            }
        }

        return true;
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
