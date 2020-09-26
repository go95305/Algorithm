package algorithm;

import java.util.Scanner;

public class B2851_슈퍼마리오 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ar[] = new int[10];

		for (int i = 0; i < 10; i++) {
			ar[i] = sc.nextInt();
		}

		int ans = 0;
		for (int i = 0; i < 10; i++) {
			int sum = 0;
			for (int j = 0; j <= i; j++) {
				sum += ar[j];
			}
			if (sum > 100) {
				if (Math.abs(100 - ans) > Math.abs(100 - sum)) {
					ans = sum;
				} else if (Math.abs(100 - ans) == Math.abs(100 - sum)) {
					ans = sum;
				}
				break;
			}
			int tmp = Math.min(100 - ans, 100 - sum);
//			System.out.println(tmp);
			if (tmp < 0) {
				break;
			}
			ans = 100 - tmp;

		}
		System.out.println(ans);
	}
}
