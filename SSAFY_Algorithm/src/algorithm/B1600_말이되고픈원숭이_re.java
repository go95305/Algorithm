package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600_말이되고픈원숭이_re {
    static int K, W, H;
    static int map[][];
    static boolean v[][][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] hr = {-1, -2, -2, -1, 1, 1, 2, 2};
    static int[] hc = {2, 1, -1, -2, -2, 2, -1, 1};

    static class Point {
        int r, c, cnt, isHorse;

        Point(int r, int c, int cnt, int isHorse) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.isHorse = isHorse;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        v = new boolean[31][H][W];
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0, 0, K));
        v[K][0][0] = true;
        int ans = -1;
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.r == H - 1 && p.c == W - 1) {
                ans = p.cnt;
                break;
            }
            if (p.isHorse > 0) {
                for (int k = 0; k < 8; k++) {
                    int nr = p.r + hr[k];
                    int nc = p.c + hc[k];
                    if (isValid(nr, nc, p.isHorse - 1)) {
                        v[p.isHorse - 1][nr][nc] = true;
                        que.add(new Point(nr, nc, p.cnt + 1, p.isHorse - 1));
                    }
                }
            }
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (isValid(nr, nc, p.isHorse)) {
                    v[p.isHorse][nr][nc] = true;
                    que.add(new Point(nr, nc, p.cnt + 1, p.isHorse));
                }
            }
        }
        if (ans == -1) {
            System.out.println(-1);
        } else
            System.out.println(ans);

    }

    private static boolean isValid(int nr, int nc, int horse) {
        if (nr >= 0 && nr < H && nc >= 0 && nc < W && !v[horse][nr][nc] && map[nr][nc] == 0)
            return true;
        return false;
    }
}
