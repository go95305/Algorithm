package algorithm;

import java.util.Scanner;

public class S1493_수의새로운연산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int map[][] = new int[1001][1001];
			int cnt = 1;
			for (int i = 1; cnt <= 100000; i++) {
				for (int j = 1, k = i; j <= i; j++, k--) {
					map[k][j] = cnt++;
				}
			}
			int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int i = 0; i < 150; i++) {
				for (int j = 0; j < 150; j++) {
					if (map[i][j] == x) {
						r1 = i;
						c1 = j;
					}
					if (map[i][j] == y) {
						r2 = i;
						c2 = j;
					}
				}
			}
			x = r1 + r2;
			y = c1 + c2;
			System.out.printf("#%d %d\n", test_case, map[x][y]);
		}
	}
}
