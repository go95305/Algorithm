package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B16987_계란으로계란치기 {
	static int ar[][];
	static boolean v[];
	static int sel[][];
	static int Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ar = new int[N][2];
		sel = new int[N][2];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			ar[i][0] = sc.nextInt();
			ar[i][1] = sc.nextInt();
		}
		Ans = 0;
		permutation(0, 1);
		System.out.println(Ans);
	}

	private static void permutation(int idx, int k) {
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.println(Arrays.toString(sel[i]));
			}
			Ans = Math.max(Ans, eggChk());
			System.out.println(Ans);
			System.out.println("------------------------");
			
			return;
		}

		for (int i = 1; i < ar.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k][0] = ar[i][0];
				sel[k][1] = ar[i][1];
				permutation(idx + 1, k + 1);
				v[i] = false;
			}
		}
	}

	private static int eggChk() {
		int cnt = 0;
		for (int i = 0; i < sel.length; i++) {
			if (sel[i][0] > 0) {
				cnt = Math.max(cnt,eggBreak(i, cnt));
				System.out.println(cnt+"..");
			}
		}
		return cnt;
	}

	private static int eggBreak(int idx, int cnt) {
		if (idx < sel.length - 1) {
			if (sel[idx][0] < sel[idx + 1][1]) {
				sel[idx][0] = 0;
				cnt++;
			} else {
				sel[idx][0] = sel[idx][0] - sel[idx + 1][1];
			}

			if (sel[idx + 1][0] < sel[idx][1]) {
				sel[idx + 1][0] = 0;
				cnt++;
			} else {
				sel[idx + 1][0] = sel[idx + 1][0] - sel[idx][1];
			}
		} else
			return 0;
		return cnt;
	}
}
