package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1987_알파벳_R {
    static int R, C;
    static char map[][];
    static boolean v[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static boolean alphabet[];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), "");
            String tmp = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        ans = 0;
        alphabet = new boolean[26];
        v = new boolean[R][C];
        alphabet[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    private static void dfs(int r, int c, int cnt) {
        ans = Math.max(ans, cnt);
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !alphabet[map[nr][nc]-'A']) {
                alphabet[map[nr][nc] - 'A'] = true;
                dfs(nr, nc, cnt + 1);
                alphabet[map[nr][nc] - 'A'] = false;

            }
        }

    }
}
