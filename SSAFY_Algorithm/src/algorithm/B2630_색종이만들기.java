package algorithm;

import java.util.Scanner;

public class B2630_색종이만들기 {
	static int N;
	static int ar[][];
	static boolean flag;
	static int one;
	static int zero;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ar = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ar[i][j] = sc.nextInt();
			}
		}
		one = 0;
		zero = 0;
		divideConquer(0, 0, N);
		System.out.println(zero);
		System.out.println(one);
	}

	private static void divideConquer(int row, int col, int n) {
		boolean chk = true;
		int value = ar[row][col];
		for (int i = row; i < row + n; i++) {
			for (int j = col; j < col + n; j++) {
				if (value != ar[i][j])
					chk = false;
				if(!chk)break;
			}
			if(!chk)break;
		}
		if (!chk) {
			divideConquer(row, col, n / 2);// 1사분면
			divideConquer(row, col + n / 2, n / 2);// 2사분면
			divideConquer(row + n / 2, col, n / 2);// 3사분면
			divideConquer(row + n / 2, col + n / 2, n / 2);// 4사분면
		} else {
			if (value == 1) {
				one++;
			}else {
				zero++;
			}
		}
	}
}
