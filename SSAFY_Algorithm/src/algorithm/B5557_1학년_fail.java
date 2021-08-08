package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B5557_1학년_fail {
    static int N;
    static int number[];
    static long dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        dp = new long[100][21];
        for (int i = 0; i < 100; i++)
            Arrays.fill(dp[i], -1);

        long ans = calc(1, number[0]);
        System.out.println(ans);

    }

    private static long calc(int idx, int num) {
        if (idx == N - 1) {
            if (num == number[N - 1]) {
                return 1;
            } else
                return 0;
        }
        if (dp[idx][num] != -1)
            return dp[idx][num];


        long valid = 0;
        if (num + number[idx] <= 20)
            valid += calc(idx + 1, num + number[idx]);
        if (num - number[idx] >= 0)
            valid += calc(idx + 1, num - number[idx]);

        dp[idx][num] = valid;
        return dp[idx][num];
    }
}
