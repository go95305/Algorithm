package algorithm;

import java.util.Scanner;

public class B10157_자리배정 {
	static int R, C, N;
	static int map[][];
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int ar[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		N = sc.nextInt();
		map = new int[R][C];
		ar = new int[2];
		if (R * C < N) {
			System.out.println(0);
			System.exit(0);
		}
		int cnt = 1;
		int r = R - 1;
		int c = 0;
		int dir = 0;
		while (cnt != N) {
			map[r][c] = cnt++;
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
				r = nr;
				c = nc;
			} else {
				dir++;
				if (dir == 4) {
					dir = 0;
				}
				r = r + dr[dir];
				c = c + dc[dir];
			}

		}
		System.out.println((c + 1) + " " + (R - r));

	}

}
