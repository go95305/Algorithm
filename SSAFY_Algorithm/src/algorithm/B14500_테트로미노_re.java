package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500_테트로미노_re {
    static int N, M;
    static int map[][];
    static boolean v[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int ans;
    static int tmpR, tmpC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                v[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                v[i][j] = false;
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int r, int c, int cnt, int sum) {
        //3개째일때 이전 칸에서 상하 좌우 해봐서도 최대값 구해야한다.
        if (cnt == 2) {
            tmpR = r;
            tmpC = c;
        }
        if (cnt == 4) {
            ans = Math.max(ans, sum);
            newWay(tmpR, tmpC, sum - map[r][c], 0);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]) {
                v[nr][nc] = true;
                dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
                v[nr][nc] = false;
            }
        }
    }

    private static void newWay(int r, int c, int sum, int cnt) {

        if (cnt == 1) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]) {
                newWay(nr, nc, sum + map[nr][nc], cnt + 1);
            }
        }
    }

}