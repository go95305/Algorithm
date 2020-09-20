package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B2578_빙고 {
	static int dr[] = { -1, -1, 1, 1 };
	static int dc[] = { -1, 1, -1, 1 };
	static int Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int map[][] = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		Ans = 0;
		for (int k = 0; k < 25; k++) {
			boolean isBingo = false;
			int erase = sc.nextInt();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == erase) {
						map[i][j] = 0;
						isBingo = check(map, k);
						if (isBingo) {
							Ans = k+1;
							break;
						}
					}
				}
				if (isBingo) {
					break;
				}
			}
			if (isBingo) {
				break;
			}
		}
		System.out.println(Ans);
	}

	private static boolean check(int[][] map, int k) {
		int bingo = 0;
		for (int i = 0; i < 5; i++) {
			int cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 0) {// 해당 셀이 0이면
					cnt++;
				} else {
					break;
				}
			}
			if (cnt == 5)
				bingo++;
		}
		for (int i = 0; i < 5; i++) {
			int cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (map[j][i] == 0) {// 해당 셀이 0이면
					cnt++;
				} else {
					break;
				}
			}
			if (cnt == 5)
				bingo++;
		}
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (map[0 + i][0 + i] == 0) {
				cnt++;
			}
			if (cnt == 5)
				bingo++;
		}
		cnt = 0;
		for (int i = 0; i < 5; i++) {// 대각선 검색(왼쪽 아래)
			if (map[0 + i][4 - i] == 0) {
				cnt++;
			}
			if (cnt == 5) {
				bingo++;
			}
		}
		if (bingo >= 3) {
			return true;
		}
		return false;
	}

}
