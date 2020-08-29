package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class S3234_준환이의양팔저울 {
	static int N;
	static int ar[];
	static int left[];
	static int sel[];
	static int right[];
	static boolean v[];
	static int Ans;
	static int sum[];
	static int total;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			ar = new int[N];
			sel = new int[N];
			sum = new int[2];
			Ans = 0;
			total = 0;
			for (int i = 0; i < N; i++) {
				ar[i] = sc.nextInt();
				total += ar[i];
			}
			v = new boolean[N];
			permutation(0, 0, 0);
			System.out.println(Ans);
		}
	}

	private static void permutation(int left, int right, int deep) {
		if (deep == N - 1) {
			Ans++;
			for (int i = 0; i < N; i++) {
				if (!v[i] && left >= right + ar[i]) {
					Ans++;
				}
			}
			return;
		}

		for (int i = 0; i < ar.length; i++) {
			if (!v[i]) {
				v[i] = true;
				permutation(left + ar[i], right, deep + 1);
				if (left >= right + ar[i]) {
					permutation(left, right + ar[i], deep + 1);
				}
				v[i] = false;
			}
		}

	}

}
