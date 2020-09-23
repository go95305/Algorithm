package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class S4613_러시아국기같은깃발 {
	static int N, M;

	static int[][] map;
	static int[][] nation;
	static int Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			nation = new int[N][M];
			Ans = Integer.MAX_VALUE;
			int arr[] = { 0, 1, 2 };
			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				for (int j = 0; j < M; j++) {
					if (tmp.charAt(j) == 'W')
						map[i][j] = 0;
					else if (tmp.charAt(j) == 'B')
						map[i][j] = 1;
					else
						map[i][j] = 2;
				}
			}
			permutation(arr, 0, new int[N], 0);
			System.out.printf("#%d %d\n", test_case, Ans);
		}
	}

	private static void permutation(int[] arr, int idx, int[] sel, int k) {
		if (k == sel.length) {
			int cnt = 0;
			for (int i = 1; i < sel.length; i++) {
				if (sel[i] > sel[i - 1]) {
					cnt++;
				} else if (sel[i] < sel[i - 1])
					cnt--;
			}
			if (cnt == 2) {
				Ans = Math.min(update(sel), Ans);
			}
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			permutation(arr, i, sel, k + 1);
		}
	}

	private static int update(int[] sel) {
		int cnt = 0;
		for (int i = 0; i < sel.length; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != sel[i]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
