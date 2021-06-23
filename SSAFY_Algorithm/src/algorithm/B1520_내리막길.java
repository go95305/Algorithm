package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1520_내리막길 {
    static int N, M;
    static int map[][];
    static int copy[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static boolean v[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        copy = new int[M][N];
        v = new boolean[M][N];
        int ans = dfs(0, 0);
        System.out.println(ans);


    }

    private static int dfs(int r, int c) {
        if (r == M - 1 && c == N - 1) {
            return 1;
        }
        if (!v[r][c]) {
            v[r][c] = true;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[r][c] > map[nr][nc]) {
                    copy[r][c] += dfs(nr, nc);
                }
            }
        }
        return copy[r][c];
    }
}
