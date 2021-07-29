package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B10711_모래성 {
    static int H, W;
    static char map[][];
    static int adj[][];
    static int ans;
    static int dr[] = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int dc[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static Queue<Point> que = new LinkedList<>();
    static Queue<Point> del = new LinkedList<>();
    static boolean v[][];

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        adj = new int[H][W];
        ans = 0;
        v = new boolean[H][W];
        init();
        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            Point p = que.poll();
            map[p.r][p.c] = '.';
            for (int k = 0; k < 8; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < H && nc >= 0 && nc < W && !v[nr][nc] && map[nr][nc] != '.') {
                    adj[nr][nc]++;
                    if (adj[nr][nc] >= map[nr][nc] - '0') {
                        v[nr][nc] = true;
                        del.add(new Point(nr, nc));
                    }
                }
            }
            if (que.isEmpty()) {
                swap();
                ans++;
            }
        }
    }

    private static void swap() {
        while (!del.isEmpty()) {
            que.add(del.poll());
        }
    }

    private static void init() {
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++) {
                if (map[i][j] != '.') {
                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '.') {
                            cnt++;
                        }
                    }
                    adj[i][j] = cnt;
                    if (cnt >= map[i][j] - '0') {
                        v[i][j] = true;
                        que.add(new Point(i, j));
                    }
                }
            }
    }
}
