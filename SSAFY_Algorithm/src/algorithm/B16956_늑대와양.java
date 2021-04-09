package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16956_늑대와양 {
    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char map[][] = new char[R][C];
        Queue<Point> que = new LinkedList<>();
        Queue<Point> sque = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'W') {
                    sque.add(new Point(i, j));
                } else if (map[i][j] == 'S')
                    que.add(new Point(i, j));
            }
        }
        boolean v[][] = new boolean[R][C];
        while (!que.isEmpty()) {
            Point p = que.poll();
            v[p.r][p.c] = true;
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[nr][nc] && map[nr][nc] != 'S' && map[nr][nc] != 'W') {
                    map[nr][nc] = 'D';
                }
            }
        }
        int ans = 1;
        v = new boolean[R][C];
        while (!sque.isEmpty()) {
            Point p = sque.poll();
            v[p.r][p.c] = true;
            if (map[p.r][p.c] == 'S') {
                ans = 0;
                break;
            }
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[nr][nc] && map[nr][nc] != 'D') {
                    v[nr][nc] = true;
                    sque.add(new Point(nr, nc));
                }
            }
        }
        if (ans == 1) {
            System.out.println(1);
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        } else
            System.out.println(0);


    }
}
