package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class S1220 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int cnt = 0;
			int sum = 0;
			int size = sc.nextInt();
			int[][] ar = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					ar[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (ar[j][i] == 1) {
						while (j < 99) {
							j++;
							if (ar[j][i] == 2) {
								cnt++;
								break;
							}
						}
					}
				}
			}
			System.out.printf("#%d %d\n",test_case,cnt);
		}
	}
}
