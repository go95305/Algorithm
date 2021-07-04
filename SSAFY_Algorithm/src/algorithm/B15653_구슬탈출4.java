package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B15653_구슬탈출4 {
    static int N, M;
    static char map[][];
    static boolean flag;
    static int ans;

    static class Point {
        int red[];
        int blue[];

        Point(int[] red, int[] blue) {
            this.red = red;
            this.blue = blue;
        }
    }

    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static boolean v[][][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        v = new boolean[N][M][N][M];
        int[] red = new int[2];
        int[] blue = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                } else if (map[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
            }
        }
        ans = 0;
        flag = false;
        v[red[0]][red[1]][blue[0]][blue[1]] = true;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(red, blue));
        move(que);
        if (flag) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }

    private static void move(Queue<Point> que) {
        int cnt = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point p = que.poll();
                for (int k = 0; k < 4; k++) {
                    int[] red = p.red.clone();
                    int[] blue = p.blue.clone();
                    if (moveFirst(red, blue, k)) {
                        if (map[red[0]][red[1]] == 'O') {
                            flag = true;
                            ans = cnt;
                            return;
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
    }

    private static boolean moveFirst(int[] red, int[] blue, int k) {
        boolean redFirst = false;
        if (k == 0) {
            if (red[0] < blue[0])
                redFirst = true;
        } else if (k == 1) {
            if (red[0] > blue[0])
                redFirst = true;
        } else if (k == 2) {
            if (red[1] < blue[1])
                redFirst = true;
        } else {
            if (red[1] > blue[1])
                redFirst = true;
        }

        int r = red[0];
        int c = red[1];
        while (true) {
            r += dr[k];
            c += dc[k];
            if (map[r][c] == '#')
                break;
            red[0] = r;
            red[1] = c;
            if (map[r][c] == 'O')
                break;
        }

        r = blue[0];
        c = blue[1];
        while (true) {
            r += dr[k];
            c += dc[k];
            if (map[r][c] == '#')
                break;
            blue[0] = r;
            blue[1] = c;
            if (map[r][c] == 'O')
                break;
        }

        if (map[blue[0]][blue[1]] == 'O')
            return false;


        if (red[0] == blue[0] && red[1] == blue[1]) {
            if (k == 0) {
                if (redFirst) {
                    blue[0]++;
                } else {
                    red[0]++;
                }
            } else if (k == 1) {
                if (redFirst) {
                    blue[0]--;
                } else {
                    red[0]--;
                }
            } else if (k == 2) {
                if (redFirst) {
                    blue[1]++;
                } else {
                    red[1]++;
                }
            } else {
                if (redFirst) {
                    blue[1]--;
                } else {
                    red[1]--;
                }
            }
        }
        return true;
    }

}