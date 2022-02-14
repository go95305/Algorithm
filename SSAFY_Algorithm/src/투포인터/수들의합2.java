package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수들의합2 {
    static int N, M;
    static int map[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        while (st.hasMoreTokens()) {
            map[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        int s = 0;
        int e = 0;
        int ans = 0;

        if (N == 1) {
            if (map[s] == M) {
                ans = 1;
            }
        } else {
            int sum = 0;
            while (e<N) {
                if (sum < M) {
                    sum += map[e++];
                } else {
                    sum -= map[s++];
                }

                if (sum == M)
                    ans++;
            }

            if (sum-map[s] == M)
                ans++;
        }
        System.out.println(ans);
    }
}
