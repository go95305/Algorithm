package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int map[][] = new int[101][101];

		int N = sc.nextInt();
		int sum = 0;
		for (int k = 0; k < N; k++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (map[i][j] == 0) {
						map[i][j]++;
						sum++;
					}
				}
			}
		}
		System.out.println(sum);

	}
}
