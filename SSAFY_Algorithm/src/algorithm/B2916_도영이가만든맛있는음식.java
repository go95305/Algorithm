package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2916_도영이가만든맛있는음식 {
    static int N;
    static int map[][];
    static boolean v[];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][2];
        int salt = 1;
        int bitter = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            salt *= map[i][0];
            bitter += map[i][1];
        }

        v = new boolean[N];
        ans = Math.abs(salt - bitter);
        dfs(1, 0, 0);
        System.out.println(ans);
    }

    private static void dfs(int salt, int bitter, int cnt) {
        if (cnt == N)
            return;

        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                int curSalt = salt * map[i][0];
                int curBitter = bitter + map[i][1];
                ans = Math.min(ans, Math.abs(curSalt - curBitter));
                dfs(curSalt, curBitter, cnt + 1);
                v[i] = false;
            }
        }
    }


}
