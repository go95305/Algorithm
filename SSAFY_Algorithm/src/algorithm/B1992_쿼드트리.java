package algorithm;

import java.util.Scanner;

public class B1992_쿼드트리 {
	static int N;
	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		quadTree(0, 0, N);
	}

	private static void quadTree(int row, int col, int n) {
		boolean chk = true;
		int std = map[row][col];
		for (int i = row; i < row + n; i++) {
			for (int j = col; j < col + n; j++) {
				if (map[i][j] != std) {
					chk = false;

				}
			}

		}
		if (!chk) {
			System.out.print("(");
			quadTree(row, col, n / 2);// 1사분면
			quadTree(row, col + n / 2, n / 2);// 2사분면
			quadTree(row + n / 2, col, n / 2);// 3사분면
			quadTree(row + n / 2, col + n / 2, n / 2);// 4사분면
			System.out.print(")");
		} else {
			System.out.print(std);
		}
	}
}
