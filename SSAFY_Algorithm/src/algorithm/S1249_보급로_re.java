package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class S1249_보급로_re {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point implements Comparable<Point> {
        int r, c, cnt;

        Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }
            boolean v[][] = new boolean[N][N];
            v[0][0] = true;
            PriorityQueue<Point> que = new PriorityQueue<>();
            que.add(new Point(0, 0, 0));
            while (!que.isEmpty()) {
                Point p = que.poll();
                if (p.r == N - 1 && p.c == N - 1) {
                    ans = p.cnt;
                    break;
                }
                for (int k = 0; k < 4; k++) {
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
                        if (p.cnt + map[nr][nc] < ans) {
                            v[nr][nc] = true;
                            que.add(new Point(nr, nc, p.cnt + map[nr][nc]));
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
