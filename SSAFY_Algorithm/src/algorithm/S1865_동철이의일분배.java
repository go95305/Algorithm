package algorithm;

import java.util.Scanner;

public class S1865_동철이의일분배 {
	static int ar[][];
	static boolean v[];
	static int max;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 100;

		for (int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			int N = sc.nextInt();
			ar = new int[N][N];
			v = new boolean[N * N];
			max = 0;
			cnt = 1;
			dfs(0, 0);
		}
	}

	private static void dfs(int x, int y) {
		if (max > cnt) {
			max = cnt;
		}
		v[x] = true;
		for (int i = x; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				cnt *= (ar[i][j] / 100);
				dfs(i, j + 1);
				v[x] = false;
			}
		}
	}
}
