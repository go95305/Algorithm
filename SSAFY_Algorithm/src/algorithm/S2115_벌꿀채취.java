package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class S2115_벌꿀채취 {
	static int map[][];
	static int N, M, C;
	static boolean v[][];
	static int Ans;
	static int[] sel1;
	static int[] rsel1;
	static int[] rsel2;
	static int[] sel2;
	static int maxComp;
	static boolean v1[];
	static boolean v2[];
	static int rAns;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			ArrayList<Integer> list1;
			ArrayList<Integer> list2;
			Ans = 0;
			rAns = 0;
			for (int i = 0; i < N; i++) {
				v = new boolean[N][N];
				for (int j = 0; j < N; j++) {
					list1 = new ArrayList<Integer>();
					if (!v[i][j] && (j + M) - 1 < N) {
						mcontain(i, j, 0, list1);
						for (int k = i + 1; k < N; k++) {
							for (int m = 0; m < N; m++) {
								list2 = new ArrayList<Integer>();
								if (!v[k][m] && (m + M) - 1 < N) {
									v[k][m] = true;
									scontain(k, m, 0, list2);
									sizeChk(list1, list2);
								}
							}
						}
						eBoolean(i, j);
					}
				}
			}
			System.out.printf("#%d %d\n", tc, rAns);

		}
	}

	private static void eBoolean(int r, int c) {
		for (int i = N - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				if (i == r && j == c)
					return;
				else
					v[i][j] = false;
			}
		}

	}

	private static void sizeChk(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		Collections.sort(list1, Collections.reverseOrder());
		Collections.sort(list2, Collections.reverseOrder());
		Ans = 0;
		sel1 = new int[M];
		v1 = new boolean[M];
		permutation1(0, 0, list1, new int[M], new boolean[M]);
		System.out.println(Arrays.toString(v1));

		Ans = 0;
		sel2 = new int[M];
		v2 = new boolean[M];
		permutation2(0, 0, list2, new int[M], new boolean[M]);
		System.out.println(Arrays.toString(v2));

		rAns = Math.max(rAns, getAns());

	}

	private static void permutation2(int idx, int k, ArrayList<Integer> list, int[] sel, boolean[] v) {
		if (k == sel.length) {
			boolean vchk[] = new boolean[M];
			int sum = maxChk(sel, vchk);
			if (Ans < sum) {
				Ans = sum;
				sel2 = sel;
				v2 = vchk;
			}
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = list.get(i);
				permutation2(i + 1, k + 1, list, sel, v);
				v[i] = false;
			}
		}
	}

	private static int getAns() {
		int sum = 0;
		for (int i = 0; i < sel1.length; i++) {
			if (v1[i])
				sum += Math.pow(sel1[i], 2);
			else
				break;
		}

		for (int i = 0; i < sel2.length; i++) {
			if (v2[i])
				sum += Math.pow(sel2[i], 2);
			else
				break;
		}
		System.out.println(sum);
		return sum;
	}

	private static void permutation1(int idx, int k, ArrayList<Integer> list, int[] sel, boolean[] v) {
		if (k == sel.length) {
			boolean vchk[] = new boolean[M];
			int sum = maxChk(sel, vchk);
			if (Ans < sum) {
				Ans = sum;
				sel1 = sel;
				v1 = vchk;
			}
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = list.get(i);
				permutation1(i + 1, k + 1, list, sel, v);
				v[i] = false;
			}
		}
	}

	private static int maxChk(int[] sel, boolean v[]) {
		int sum = 0;
		for (int i = 0; i < sel.length; i++) {
			if (sum + sel[i] <= C) {
				v[i] = true;
				sum += sel[i];
			} else
				break;
		}

		return sum;
	}

	private static void scontain(int r, int c, int cnt, ArrayList<Integer> list) {
		if (cnt == M) {
			return;
		}
		list.add(map[r][c]);
		int nc = c + 1;
		if (nc < N && !v[r][nc]) {
			v[r][nc] = true;
			mcontain(r, nc, cnt + 1, list);
			v[r][nc] = false;
		}

	}

	private static void mcontain(int r, int c, int cnt, ArrayList<Integer> list) {
		if (cnt == M) {
			return;
		}
		v[r][c] = true;
		list.add(map[r][c]);
		int nc = c + 1;
		if (nc < N && !v[r][nc]) {
			mcontain(r, nc, cnt + 1, list);
		}
	}
}
