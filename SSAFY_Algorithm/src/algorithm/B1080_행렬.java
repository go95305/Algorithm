package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1080_행렬 {
	static int N, M;
	static int A[][];
	static int B[][];
	static boolean flag;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		A = new int[N][M];
		B = new int[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < M; j++) {
				A[i][j] = tmp.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < M; j++) {
				B[i][j] = tmp.charAt(j) - '0';
			}
		}
		ans = 0;
		flag = true;
		if (N < 3 || M < 3) {
			flag = false;
		} else {
			swip(0, 0);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					flag = false;
				}
			}
		}
		if (flag) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
	}

	private static void swip(int row, int col) {
		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 3; j++) {
				change(i, j);// 이 부분에서 순차적으로 바꾸는게 아니라 정답이 나올 수 있도록 순서없이 돌릴 수도 있다.
				ans++;
			}
		}

	}

	private static void change(int row, int col) {
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (A[i][j] == 1)
					A[i][j] = 0;
				else
					A[i][j] = 1;
			}
		}
	}

}
