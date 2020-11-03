package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S5656_벽돌깨기 {
	static int N, W, H;
	static int map[][];
	static int mapCopy[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean v[][];
	static int arr[];
	static int Ans;

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();

			map = new int[H][W];
			mapCopy = new int[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
					mapCopy[i][j] = map[i][j];
				}
			}
			v = new boolean[H][W];
			arr = new int[N];
			Ans = W * H;
			permutation(0, 0);
			System.out.println(Ans);

		}
	}

	private static int selectFinal() {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void permutation(int idx, int k) {

		if (k == arr.length) {
			// 뽑은 중복순열로 구현을 한다.
			breakdown(arr);
			Ans = Math.min(Ans, selectFinal());
			print();
			reset();
			return;
		}

		for (int i = 0; i < W; i++) {
			arr[k] = i;
			permutation(i + 1, k + 1);
		}
	}

	private static void reset() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = mapCopy[i][j];
			}
		}

	}

	private static void breakdown(int[] arr) {
//		print();
		for (int i = 0; i < arr.length; i++) {
			int col = arr[i];

			for (int j = 0; j < H; j++) {
				if (map[j][col] > 0) {
					if (map[j][col] == 1)
						map[j][col] = 0;
					else {
						v[j][col] = true;
						destroy(j, col, map[j][col], 1);
						v[j][col] = false;
					}
					map = newMap();
					v = new boolean[H][W];
				}
			}
		}

	}

	private static void print() {
		for (int i = 0; i < H; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("=====================");

	}

	private static int[][] newMap() {
		int newmap[][] = new int[H][W];
		for (int i = 0; i < W; i++) {
			int idx = H - 1;
			for (int j = H - 1; j >= 0; j--) {
				if (map[j][i] > 0) {
					newmap[idx][i] = map[j][i];
					idx--;
				}
			}
		}
		return newmap;
	}

	private static void destroy(int r, int c, int value, int cnt) {
		if (value == cnt) {
			if (map[r][c] > 0) {
				if (map[r][c] == 1)
					map[r][c] = 0;
				else
					destroy(r, c, map[r][c], 1);
				return;
			}
			return;
		}
		map[r][c] = 0;

		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nr < H && nc >= 0 && nc < W && !v[nr][nc]) {
				v[nr][nc] = true;
				destroy(nr, nc, value, cnt + 1);
				v[nr][nc] = false;
				return;

			}
		}
	}
}
