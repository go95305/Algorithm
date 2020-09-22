package algorithm;

import java.util.Scanner;

public class B2491_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = 1;
		int max = 1;
		int ans = 1;
		int ar[] = new int[N];
		for (int i = 0; i < N; i++) {
			ar[i] = sc.nextInt();
		}

		for (int i = 1; i < ar.length; i++) {
			if (ar[i - 1] > ar[i]) {
				min++;
				max = 1;
			} else if (ar[i - 1] < ar[i]) {
				max++;
				min = 1;
			} else {
				min++;
				max++;
			}
			ans = Math.max(ans,Math.max(max, min));
		}
		System.out.println(ans);
	}
}
