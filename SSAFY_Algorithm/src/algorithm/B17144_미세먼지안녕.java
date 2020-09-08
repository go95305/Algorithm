package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B17144_미세먼지안녕 {
	static int R, C, T;
	static int map[][];
	static boolean[][] v;
	static int drUp[] = { 0, -1, 0, 1 };
	static int dcUp[] = { 1, 0, -1, 0 };
	static int drDown[] = { 0, 1, 0, -1 };
	static int dcDown[] = { 1, 0, -1, 0 };
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();// T초후 미세먼지양
		map = new int[R][C];
		v = new boolean[R][C];
		int airmove[] = new int[2];
		int move = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] > 0) {
					v[i][j] = true;
				}
				if (map[i][j] == -1) {
					airmove[move] = i;
					move++;
				}
			}
		}
		int cnt = 0;
		while (cnt < T) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 4 && v[i][j] == true) {
						spread(i, j);
					}
				}
			}
			v=new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					v[i][j]=true;
				}
			}
			airUp(airmove[0], 1, 0);
			map[airmove[0]][1] = 0;
			airDown(airmove[1], 1, 0);
			map[airmove[1]][1] = 0;

			cnt++;
		}
		sum=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]!=-1) {
					sum+=map[i][j];
				}
			}
		}
		System.out.println(sum);
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

	}

	private static void airDown(int x, int y, int dir) {
		for (int k = dir; k < 4; k++) {
			int nr = x + drDown[k];
			int nc = y + dcDown[k];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
				airDown(nr, nc, k);
				map[nr][nc] = map[x][y];
				return;
			}
		}

	}

	private static void airUp(int x, int y, int dir) {
		for (int k = dir; k < 4; k++) {
			int nr = x + drUp[k];
			int nc = y + dcUp[k];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
				airUp(nr, nc, k);
				map[nr][nc] = map[x][y];
				return;
			}
		}
	}

	private static void spread(int x, int y) {
		v[x][y] = false;
		int slice = map[x][y] / 5;
		int cnt = 0;
		for (int k = 0; k < 4; k++) {
			int nr = x + drUp[k];
			int nc = y + dcUp[k];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
				if (v[nr][nc]) {
					spread(nr, nc);
				}
				map[nr][nc] += slice;
				cnt++;
			}
		}
		map[x][y] -= (slice * cnt);
	}
}
