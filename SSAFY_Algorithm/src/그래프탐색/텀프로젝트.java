package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 텀프로젝트 {
    static int T;
    static int N;
    static int map[];
    static boolean v[];
    static boolean ans[];
    static boolean flag;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                map[i] = Integer.parseInt(st.nextToken()) - 1;
            }
            ans = new boolean[N];
            v = new boolean[N];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                if (!ans[i]) {
                    dfs(i);
                }
            }
            System.out.println(Arrays.toString(ans));
            System.out.println(N - cnt);


        }
    }

    private static void dfs(int cur) {
        if (v[cur]) {
            ans[cur] = true;
            cnt++;
        } else {
            v[cur] = true;
        }

        int next = map[cur];
        if (!ans[next])
            dfs(next);

        ans[cur] = true;
    }
}
/*
1 -T
3 -T
2 -T
4 -T
7 -T
6 -T



3-T
1-T
4-T
cnt=3

 */

