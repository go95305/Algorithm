package algorithm;

import java.util.Scanner;

public class B1987_알파벳 {
	static int R, C;
	static char alp[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int chk[];
	static int cnt, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		alp = new char[R][C];
		chk = new int[26];
		for (int i = 0; i < R; i++) {
			String tmp = sc.next();
			for (int j = 0; j < C; j++) {
				alp[i][j] = tmp.charAt(j);
			}
		}
		cnt = 1;
		max = 0;
		dfs(0, 0, alp[0][0], 1);
		System.out.println(max);

	}

	private static void dfs(int x, int y, char c, int cnt) {
		if (max < cnt) {
			max = cnt;
		}
		chk[c - 'A'] = 1;
		for (int k = 0; k < 4; k++) {
			int nr = x + dr[k];
			int nc = y + dc[k];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && chk[alp[nr][nc] - 'A'] != 1) {
				dfs(nr, nc, alp[nr][nc], cnt + 1);
				chk[alp[nr][nc] - 'A'] = 0;
			}
		}
	}
}
