package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16932_모양만들기 {
    static int N, M;
    static int map[][];
    static boolean v[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans;
    static int cnt;
    static int idx;
    static int area[];
    static Set<Integer> hs;

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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    que.add(new Point(i, j));
            }
        }
        v = new boolean[N][M];
        area = new int[500000];
        idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !v[i][j]) {
                    cnt = 1;
                    map[i][j] = idx;
                    v[i][j] = true;
                    dfs(i, j);
                    area[idx] = cnt;
                    idx++;
                }
            }
        }
        ans = 0;
        hs = new HashSet<>();
        while (!que.isEmpty()) {
            Point p = que.poll();
            searchArea(p.r, p.c);
        }
        System.out.println(ans);
    }

    private static void searchArea(int r, int c) {
        hs.clear();
        int size = 0;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (map[nr][nc] > 0) {
                    hs.add(map[nr][nc]);
                }
            }
        }
        int sum = 0;
        for (int k : hs) {
            sum += area[k];
        }
        ans = Math.max(ans, 1 + sum);
    }

    private static void dfs(int r, int c) {
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] > 0) {
                v[nr][nc] = true;
                map[nr][nc] = idx;
                cnt++;
                dfs(nr, nc);
            }
        }
    }

}
