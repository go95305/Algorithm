package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14923_미로탈출 {
    static class Point {
        int r, c, len, wall;

        Point(int r, int c, int len, int wall) {
            this.r = r;
            this.c = c;
            this.len = len;
            this.wall = wall;
        }
    }

    static int ans;
    static int N, M;
    static int map[][];
    static boolean v[][][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine(), " ");
        int ex = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;


        v = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        map[ex][ey] = 2;
        ans = Integer.MAX_VALUE;
        search(x, y, 0, 0);
        if (ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);

    }

    private static void search(int r, int c, int len, int wall) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(r, c, len, wall));
        v[wall][r][c] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (map[p.r][p.c] == 2) {
                ans = Math.min(ans, p.len);

            }
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[p.wall][nr][nc]) {
                    if (map[nr][nc] == 1) {
                        if (p.wall == 0) {
                            v[p.wall+1][nr][nc] = true;
                            que.add(new Point(nr, nc, p.len + 1, p.wall + 1));
                        }
                    } else {
                        v[p.wall][nr][nc] = true;
                        que.add(new Point(nr, nc, p.len + 1, p.wall));
                    }
                }
            }
        }

    }
}
