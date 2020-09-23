package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B1244_스위치켜고끄기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 스위치 수
		int swt[] = new int[N];

		for (int i = 0; i < N; i++) {
			swt[i] = sc.nextInt();
		}

		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int gender = sc.nextInt();
			int switchNum = sc.nextInt();

			if (gender == 1) {
				for (int j = switchNum; j <= swt.length; j = j + switchNum) {
					swt[j - 1] = swt[j - 1] ^ 1;
				}

			} else {
				int cnt = 1;
				swt[switchNum - 1] = swt[switchNum - 1] ^ 1;
				while ((switchNum - 1) - cnt >= 0 && (switchNum - 1) + cnt < N) {
					if (swt[switchNum - 1 - cnt] == swt[switchNum - 1 + cnt]) {
						swt[switchNum - 1 - cnt] = swt[switchNum - 1 + cnt] = swt[switchNum - 1 - cnt] ^ 1;
						cnt++;
					} else {
						break;
					}
				}
			}
		}
		for (int i = 0; i < swt.length; i++) {
			if ((i % 20 == 0 && i != 0)) {
				System.out.println();
				System.out.print(swt[i]+" ");
			} else {
				System.out.print(swt[i] + " ");
			}
		}
	}
}
