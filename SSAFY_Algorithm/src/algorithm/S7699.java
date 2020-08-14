package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S7699 {
	static int R;
	static int C;
	static char ar[][];
	static boolean[] v;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int cnt;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			cnt = 0;
			max = 0;
			R = sc.nextInt();
			C = sc.nextInt();
			ar = new char[R][C];
			v = new boolean[26];
			for (int i = 0; i < R; i++) {
				String tmp = sc.next();
				for (int j = 0; j < C; j++) {
					ar[i][j] = tmp.charAt(j);
				}
			}
			dfs(0, 0, ar[0][0]);
			if (max == 0) {
				max = 1;
			}
			System.out.printf("#%d %d\n", test_case, max);
		}
	}

	private static void dfs(int i, int j, char alp) {
		v[alp - 'A'] = true;
		cnt++;
		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[ar[nr][nc] - 'A']) {
				v[ar[nr][nc] - 'A'] = true;
				dfs(nr, nc, ar[nr][nc]);
				v[ar[nr][nc] - 'A'] = false;
				if (max < cnt) {
					max = cnt;
				}
				cnt--;
			}
		}
	}

	static class Point {
		int x;
		int y;
		char c;

		Point(int x, int y, char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
