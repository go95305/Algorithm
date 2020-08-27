package algorithm;

import java.util.Scanner;

/*
 * 가장 위의 파이프를 골라야 최대한 많이 설치가능
 * 
 */
public class B3109_빵집 {
	static int R, C;
	static char ar[][];
	static int answer;
	static int max;
	static int row[];
	static boolean v[][];
	static int dr[] = { -1, 0, 1 };
	static int dc[] = { 1, 1, 1 };
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		max = 0;
		v = new boolean[R][C];
		ar = new char[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = sc.next();
			for (int j = 0; j < C; j++) {
				ar[i][j] = tmp.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);
		}

		System.out.println(answer);
	}

	private static void dfs(int x, int y) {
		if (y == C - 1) {
			flag = true;
			answer++;
			return;
		}
		v[x][y] = true;
		for (int k = 0; k < 3; k++) {
			int nr = x + dr[k];
			int nc = y + dc[k];
			if (nr >= 0 && nr < R && nr >= 0 && nc < C && !v[nr][nc] && ar[nr][nc] != 'x') {
				dfs(nr, nc);
				if (flag) {
					return;
				}
			}
		}
	}

}
