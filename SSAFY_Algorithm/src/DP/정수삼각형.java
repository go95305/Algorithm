package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];
        int dp[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i+1; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }
        int ans = 0;
        if (N == 1) {
            ans = arr[0][0];
        } else {
            for (int i = 0; i < N; i++) {
                dp[i] = arr[i].clone();
            }
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == 0) {
                        dp[i + 1][j] = arr[i][j] + arr[i + 1][j];
                        dp[i + 1][j + 1] = arr[i][j] + arr[i + 1][j + 1];

                    } else {
                        if (dp[i + 1][j] < dp[i][j] + arr[i + 1][j])
                            dp[i + 1][j] = dp[i][j] + arr[i + 1][j];
                        dp[i + 1][j + 1] = dp[i][j] + arr[i + 1][j + 1];
                    }
                }
            }
            int max = 0;
            for (int i=0;i<N;i++){
                max = Math.max(max,dp[N-1][i]);
            }
            ans=max;
        }

        System.out.println(ans);
    }
}
