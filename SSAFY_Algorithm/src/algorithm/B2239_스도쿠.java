package algorithm;

import java.util.Scanner;

public class B2239_스도쿠 {
	static int N;
	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 9;
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		sudoku();

	}

	private static void sudoku() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == N - 1 && j == N - 1) {
					print();
					System.exit(0);
				}
				boolean v[] = new boolean[10];
				if (map[i][j] == 0) {
					chk(i, j, v);
					for (int k = 1; k <= 9; k++) {
						if (!v[k]) {
							map[i][j] = k;
							sudoku();
							map[i][j] = 0;
						}
					}
					return;
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	private static void chk(int r, int c, boolean[] v) {
		rightChk(r, v);
		colChk(c, v);

		int row = r / 3 * 3;
		int col = c / 3 * 3;
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				v[map[i][j]] = true;
			}
		}

	}

	private static void colChk(int c, boolean[] v) {
		for (int i = 0; i < map.length; i++) {
			v[map[i][c]] = true;
		}
	}

	private static void rightChk(int r, boolean[] v) {
		for (int i = 0; i < map.length; i++) {
			v[map[r][i]] = true;

		}
	}
}
