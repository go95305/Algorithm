package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7836_공주님구해라 {
    static int N, M, K;
    static int map[][];
    static boolean v[][][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    static class Point {
        int r, c, cnt, wall;


        Point(int r, int c, int cnt, int wall) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int ans = 0;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        v = new boolean[2][N][M];
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0, 0, 0));
        v[0][0][0] = true;

        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.cnt > K)
                continue;

            if (p.r == N - 1 && p.c == M - 1) {
                ans = p.cnt;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[p.wall][nr][nc]) {
                    if (map[nr][nc] == 1) {
                        if (p.wall == 1) {
                            v[p.wall][nr][nc] = true;
                            que.add(new Point(nr, nc, p.cnt + 1, p.wall));
                        }
                    } else if (map[nr][nc] == 0) {
                        v[p.wall][nr][nc] = true;
                        que.add(new Point(nr, nc, p.cnt + 1, p.wall));
                    } else {
                        v[p.wall][nr][nc] = true;
                        que.add(new Point(nr, nc, p.cnt + 1, 1));
                    }
                }
            }
        }
        if (ans == 0)
            System.out.println("Fail");
        else
            System.out.println(ans);
    }
}
