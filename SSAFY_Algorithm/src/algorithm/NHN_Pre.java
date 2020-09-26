package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NHN_Pre {
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean v[][];
	static int map[][];
	static int N;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		v = new boolean[N][N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					cnt = 1;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list);
	}

	private static void dfs(int r, int c) {
		v[r][c] = true;
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] == 1) {
				cnt++;
				dfs(nr, nc);
			}
		}
	}
}
