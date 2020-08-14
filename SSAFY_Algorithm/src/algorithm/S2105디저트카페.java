package algorithm;

import java.util.Scanner;

public class S2105디저트카페 {
	static int N;
	static int ar[][];
	static boolean v[];
	static int r;
	static int c;
	static int cnt;
	static int max;
	static int dr[] = { 1, 1, -1, -1 };// 대각선 이동
	static int dc[] = { 1, -1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			ar = new int[N][N];
			v = new boolean[10];
			cnt = 0;
			max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ar[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j <= N - 2; j++) {
					cnt = 0;
					r = i;
					c = j;
					dfs(i, j, 0, i + 1);
					System.out.println(cnt);
					v = new boolean[10];
				}
			}
//			System.out.println(max);
		}
	}

	private static void dfs(int x, int y, int dir, int move) {
		if (dir == 4 && v[ar[r][c]]) {
			if (max < cnt) {
				max = cnt;
			}
			return;
		}
		v[ar[x][y]] = true;
		for (int k = dir; k < 4; k++) {
			for (int i = 1; i <= move; i++) {
				int nr = x + dr[k] * i;
				int nc = y + dc[k] * i;
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[ar[nr][nc]]) {
					v[ar[nr][nc]] = true;
					cnt++;
					dfs(nr, nc, dir + 1, move);
				}
			}
		}
	}

}
