package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B_파이프옮기기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		long dp[][][] = new long[3][N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0][1] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j + 1 < N && map[i][j + 1] == 0) {
					dp[0][i][j + 1] += dp[0][i][j];
					dp[0][i][j + 1] += dp[1][i][j];
				}
				if (j + 1 < N && i + 1 < N && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0 && map[i][j + 1] == 0) {
					dp[1][i + 1][j + 1] += dp[0][i][j];
					dp[1][i + 1][j + 1] += dp[2][i][j];
					dp[1][i + 1][j + 1] += dp[1][i][j];
				}
				if (i + 1 < N && map[i + 1][j] == 0) {
					dp[2][i + 1][j] += dp[2][i][j];
					dp[2][i + 1][j] += dp[1][i][j];
				}
			}
		}
		long answer = 0;
		for (int i = 0; i < 3; i++) {
			answer += dp[i][N - 1][N - 1];
		}
		System.out.println(answer);

	}

}
