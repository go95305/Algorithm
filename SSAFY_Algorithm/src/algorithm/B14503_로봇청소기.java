package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B14503_로봇청소기 {
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	static int b_dr[] = { 1, 0, -1, 0 };
	static int b_dc[] = { 0, -1, 0, 1 };
	static int map[][];
	static boolean v[][];
	static int N, M;
	static boolean flag;
	static int cleaned;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		int r = sc.nextInt();
		int c = sc.nextInt();
		int dir = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		cleaned = 0;
		clean(r, c, dir);
		System.out.println(cleaned);

	}

	private static void clean(int r, int c, int dir) {

		if (map[r][c] == 1)
			return;
		if (map[r][c] == 0) {
			map[r][c] = 2;
			cleaned++;
		}
		for (int k = 0; k < 4; k++) {
			int nextDir = dir - 1 < 0 ? 3 : dir - 1;
			int nr = r + dr[nextDir];
			int nc = c + dc[nextDir];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
				clean(nr, nc, nextDir);
				return;
			} else {
				dir = nextDir;
			}
		}

		int nr = r + b_dr[dir];
		int nc = c + b_dc[dir];
		clean(nr, nc, dir);
	}
}
