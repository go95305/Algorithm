package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class J1106_장기_BFS {
    static int R, C, S, K, N, M;
    static int map[][];
    static int dr[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int dc[] = {1, 2, 2, 1, -1, -2, -2, -1};

    static class Point {
        int r, c, cnt;

        Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        R = sc.nextInt();
        C = sc.nextInt();
        S = sc.nextInt();
        K = sc.nextInt();
        boolean v[][] = new boolean[N][M];
        int ans = Integer.MAX_VALUE;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(R, C, 0));
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.r == S && p.c == K) {
                ans = Math.min(ans, p.cnt);
                break;
            }
            for (int k = 0; k < 8; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]) {
                    v[nr][nc] = true;
                    que.add(new Point(nr, nc, p.cnt + 1));
                }
            }
        }
        System.out.println(ans);
    }
}
