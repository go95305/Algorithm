package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class S4014_활주로건설 {
	static int map[][];
	static int Ans;
	static int N;
	static boolean v[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			int X = sc.nextInt();// 경사로의 길이
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			Ans = 0;
			v = new boolean[N][N];

			/** 행 단위 검사 */
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if (map[i][j - 1] - map[i][j] == 1) {// 오른쪽으로 탐색을통해 활주로 건설
						boolean flag = hwalR(map[i][j], i, j, X);
						if (flag) {
							newHeightR(i, j, map[i][j - 1], X);// 활주로로 높이를 맞춰주기
						}
						print();
						printBool();
					} else if (map[i][j - 1] - map[i][j] == -1) {// 왼쪽 탐색을 통해 활주로 건설
						boolean flag = hwalL(map[i][j - 1], i, j - 1, X);
						if (flag) {
							newHeightL(i, j - 1, map[i][j], X);// 활주로로 높이를 맞춰주기
						}
						print();
						printBool();
					}
				}
				Ans += isBuildR(i);
			}

			v = new boolean[N][N];
			/** 열 단위 검사 */
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if (map[j - 1][i] - map[j][i] == 1) {// 오른쪽으로 탐색을통해 활주로 건설
						boolean flag = hwalD(map[j][i], j, i, X);
						if (flag) {
							newHeightD(j, i, map[j][i], X);// 활주로로 높이를 맞춰주기
						}
//						print();
//						printBool();
					} else if (map[j - 1][i] - map[j][i] == -1) {// 왼쪽 탐색을 통해 활주로 건설
						boolean flag = hwalU(map[j - 1][i], j - 1, i, X);
						if (flag) {
							newHeightU(j - 1, i, X);// 활주로로 높이를 맞춰주기
						}
//						print();
//						printBool();
					}
				}
				Ans += isBuildL(i);
			}
			System.out.printf("#%d %d\n", test_case, Ans);
		}
	}

	private static int isBuildL(int c) {
		for (int i = 1; i < map.length; i++) {
			if (map[i - 1][c] - map[i][c] >= 1) {
				if (!v[i][c])
					return 0;
			} else if (map[i - 1][c] - map[i][c] <= -1) {
				if (!v[i - 1][c])
					return 0;
			}
		}
		return 1;
	}

	private static void newHeightU(int r, int c, int len) {
		for (int i = r; i > r - len; i--) {
			v[i][c] = true;
		}

	}

	private static boolean hwalU(int height, int r, int c, int len) {
		for (int i = r; i > r - len; i--) {
			if (i < 0 || map[i][c] != height || v[i][c]) {
				return false;// 활주로 길이만큼 좌표값이 이어지지않으면
			}
		}
		return true;// 활주로 길이만큼 좌표값이 이어지면
	}

	private static void newHeightD(int r, int c, int height, int len) {
		for (int i = r; i < r + len; i++) {
			v[i][c] = true;
		}

	}

	private static boolean hwalD(int height, int r, int c, int len) {
		for (int i = r; i < len + r; i++) {
			if (i >= N || map[i][c] != height || v[i][c]) {
				return false;// 활주로 길이만큼 좌표값이 이어지지않으면
			}
		}
		return true;// 활주로 길이만큼 좌표값이 이어지면
	}

	private static void printBool() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(v[i]));
		}
		System.out.println("................");
	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("=======================");
		System.out.println();
	}

	private static void newHeightL(int r, int c, int height, int len) {
		for (int i = c; i > c - len; i--) {
			v[r][i] = true;
		}
	}

	private static boolean hwalL(int height, int r, int c, int len) {
		for (int i = c; i > c - len; i--) {
			if (i < 0 || map[r][i] != height || v[r][i]) {
				return false;// 활주로 길이만큼 좌표값이 이어지지않으면
			}
		}
		return true;// 활주로 길이만큼 좌표값이 이어지면
	}

	private static int isBuildR(int r) {
		for (int i = 1; i < map.length; i++) {
			if (map[r][i - 1] - map[r][i] >= 1) {
				if (!v[r][i])
					return 0;
			} else if (map[r][i - 1] - map[r][i] <= -1) {
				if (!v[r][i - 1])
					return 0;
			}
		}
		return 1;

	}

	private static void newHeightR(int r, int c, int height, int len) {
		for (int i = c; i < len + c; i++) {
			v[r][i] = true;
		}
	}

	private static boolean hwalR(int height, int r, int c, int len) {
		for (int i = c; i < len + c; i++) {
			if (i >= N || map[r][i] != height || v[r][i]) {
				return false;// 활주로 길이만큼 좌표값이 이어지지않으면
			}
		}
		return true;// 활주로 길이만큼 좌표값이 이어지면

	}
}
