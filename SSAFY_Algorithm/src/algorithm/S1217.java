package algorithm;

import java.util.Scanner;

public class S1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int num = sc.nextInt();
			int sum = 1;
			int A = sc.nextInt();
			int B = sc.nextInt();
			for (int i = 0; i < B; i++) {
				sum *= A;
			}
			System.out.printf("#%d %d\n", num, sum);
			sum = 1;
		}
	}
}
