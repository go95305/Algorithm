package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4179_불 {
    static int R, C;
    static char map[][];
    static boolean v[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        Queue<Point> jihoon = new LinkedList<>();
        Queue<Point> fire = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'J')
                    jihoon.add(new Point(i, j));
                if (map[i][j] == 'F')
                    fire.add(new Point(i, j));
            }
        }
        int ans = 0;
        boolean flag = false;
        boolean isContinue = true;
        int time = 1;
        while (!jihoon.isEmpty()) {
            int size = fire.size();
            for (int i = 0; i < size; i++) {
                Point p = fire.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != '#' && map[nr][nc] != 'F') {
                        map[nr][nc] = 'F';
                        fire.add(new Point(nr, nc));
                    }
                }
            }

            size = jihoon.size();
            for (int i = 0; i < size; i++) {
                Point p = jihoon.poll();
                if (p.r == R - 1 || p.c == C - 1 || p.r == 0 || p.c == 0) {
                    ans = time;
                    isContinue = false;
                    flag = true;
                    break;
                }
                for (int k = 0; k < 4; k++) {
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
                        map[nr][nc] = 'J';
                        jihoon.add(new Point(nr, nc));
                    }
                }
            }

            if (!isContinue) {
                break;
            }
            time++;
        }

        if (!flag)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(ans);
    }
}
