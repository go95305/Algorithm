package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7569_토마토 {
    static int map[][][];
    static boolean v[][][];
    static int N, M, H;
    static int dr[] = {-1, 1, 0, 0, 0, 0};
    static int dc[] = {0, 0, -1, 1, 0, 0};
    static int dh[] = {0, 0, 0, 0, 1, -1};
    static Queue<Point> que = new LinkedList<>();

    static class Point {
        int h, r, c, time;

        Point(int h, int r, int c, int time) {
            this.h = h;
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        map = new int[H][N][M];
        v = new boolean[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = sc.nextInt();
                    if (map[i][j][k] == 1) {
                        que.add(new Point(i, j, k, 0));
                        v[i][j][k] = true;
                    }
                }
            }
        }
        int ans = 0;
        while (!que.isEmpty()) {
            Point p = que.poll();
            ans = Math.max(ans, p.time);
            for (int k = 0; k < 6; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                int nh = p.h + dh[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && nh >= 0 && nh < H && !v[nh][nr][nc] && map[nh][nr][nc] == 0) {
                    map[nh][nr][nc] = 1;
                    que.add(new Point(nh, nr, nc, p.time + 1));
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0)
                        ans = -1;
                }
            }
        }

        System.out.println(ans);

//        for (int i = 0; i < H; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.println(Arrays.toString(map[i][j]));
//            }
//        }
    }


}
