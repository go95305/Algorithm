package algorithm;

import java.util.Scanner;

public class S1974_스도쿠검증 {
	static int map[][];
	static int Ans;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			map = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			flag = true;
			for (int i = 0; i < 9; i = i + 3) {// 3X3씩 검사하므로 +3해준다.
				for (int j = 0; j < 9; j = j + 3) {
					divideConquer(i, j, new int[9]);
				}
			}
			if (flag) {
				System.out.printf("#%d %d\n", test_case, 1);
			} else {
				System.out.printf("#%d %d\n", test_case, 0);
			}
		}
	}

	private static void divideConquer(int r, int c, int[] v) {

		for (int i = 0; i < 9; i++) {// 해당 행 과 열 한줄을 검사한다.
			v[map[r][i] - 1]++;
			v[map[i][r] - 1]++;
			if (v[map[i][0] - 1] > 2 || v[map[0][i] - 1] > 2) {// 겹치는 숫자가 없으면 모두 2의 값을가진다. 아니면 중복값이 있는것이므로 return
				flag = false;
				return;
			}
		}

		/** 위의 조건을 만족했으면 이제 3X3크기안에서 중복이있는지를 확인 */
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				v[map[i][j] - 1]++;
				if (v[map[i][j] - 1] > 3) {// 3X3크기안에서 중복값이 있으면(3보다크면) return;
					flag = false;
					return;
				}
			}
		}
	}
}
