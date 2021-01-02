package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1106_장기_DFS {
    static int R, C, S, K, N, M;
    static int map[][];
    static int dr[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int dc[] = {1, 2, 2, 1, -1, -2, -2, -1};
    static boolean v[][];
    static int ans;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        v = new boolean[N][M];
        ans = Integer.MAX_VALUE;
        v[R][C] = true;
        dfs(R, C, 0);
        System.out.println(ans);
    }

    private static void dfs(int r, int c, int cnt) {
        if (cnt > ans)
            return;
        if (r == S && c == K) {
            ans = Math.min(ans, cnt);
            return;
        }
        for (int k = 0; k < 8; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]) {
                v[nr][nc] = true;
                dfs(nr, nc, cnt + 1);
                v[nr][nc] = false;
            }
        }
    }
}
