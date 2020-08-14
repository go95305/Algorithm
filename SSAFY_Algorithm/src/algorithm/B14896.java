package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class B14896 {
	static int[] ar;
	static boolean[] v;
	static int sum = 0;
	static int cnt = 0;
	static Stack<Integer> st = new Stack<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		ar = new int[N];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			ar[i] = sc.nextInt();
		}
		powerSet(0, S, 0);
		System.out.println(cnt);

	}

	private static void powerSet(int idx, int S, int k) {
		if (idx == ar.length) {
			if (k > 0) {
				for (int i = 0; i < ar.length; i++) {
					if (v[i] == true) {
						sum+=ar[i];
					}
				}
			}
			if (k > 0 && sum == S) {
				cnt++;
			}
//			System.out.println();
			sum = 0;
			return;
		}
		v[idx] = true;
		powerSet(idx + 1, S, k + 1);
		v[idx] = false;
		powerSet(idx + 1, S, k);

	}
}
