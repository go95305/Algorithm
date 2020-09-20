package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class S1940_가랏RC카 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int len = 0;
			int speed = 0;
			for (int i = 0; i < N; i++) {
				int gasok = sc.nextInt();
				if (gasok == 0) {
					len += speed;
					continue;
				}

				if (gasok == 1) {
					int tmp = sc.nextInt();
					speed += tmp;
				} else {
					int tmp = sc.nextInt();
					if (speed < tmp) {
						speed = 0;
					} else {
						speed -= tmp;
					}
				}
				len += speed;
			}
			System.out.printf("#%d %d\n",test_case,len);

		}
	}
}
