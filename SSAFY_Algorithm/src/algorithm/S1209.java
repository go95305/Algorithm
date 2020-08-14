package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S1209 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\고유창\\git\\javase\\src\\algorithm\\testcase.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int dr[] = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int dc[] = { 0, 0, -1, 1, -1, 1, 1, -1 };
		for (int test_case = 1; test_case <= T; test_case++) {
			int sum = 0;
			int max = 0;
			int num = sc.nextInt();
			int[][] ar = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ar[i][j] = sc.nextInt();
				}
			}

			int x = 0;// 초기 x, y좌표
			int y = 0;
			for (int i = 0; i < 100; i++) {
				for (int k = 0; k < 8; k++) {
					for (int j = 1; j < 100; j++) {
						int nr = x + dr[k] * j;
						int nc = y + dc[k] * j;
						if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100) {
							sum += ar[nr][nc];
						} else {
							break;
						}
					}
					if (k % 2 == 1) {
						sum = sum + ar[x][y];
						if (max < sum) {
							max = sum;
						}
						sum = 0;
					}
				}
				x += 1;
				y += 1;
			}
			System.out.printf("#%d %d\n", num, max);

		}
	}

}
