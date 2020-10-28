package algorithm;

import java.util.Scanner;

public class S4014_활주로건설 {
	static int map[][];
	static int Ans;
	static int N;

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
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if (map[i][j - 1] - map[i][j] == 1) {// 오른쪽으로 탐색을통해 활주로 건설
						boolean flag = hwalR(map[i][j], i, j, X);
						if (flag) {
							newHeightR(i, j, map[i][j - 1], X);// 활주로로 높이를 맞춰주기
						}
					} else if (map[i][j - 1] - map[i][j] == -1) {// 왼쪽 탐색을 통해 활주로 건설
						boolean flag = hwalL(map[i][j - 1], i, j - 1, X);
						if (flag) {
							newHeightL(i, j, map[i][j - 1], X);// 활주로로 높이를 맞춰주기
						}
					}
					Ans += isBuild(i);
				}
			}
			System.out.println(Ans);
		}
	}

	private static void newHeightL(int r, int c, int height, int len) {
		for (int i = c; i < len + c; i++) {
			map[r][i] = height;
		}
	}

	private static boolean hwalL(int height, int r, int c, int len) {
		for (int i = c; i > c - len; i--) {
			if (map[r][i] != height) {
				return false;// 활주로 길이만큼 좌표값이 이어지지않으면
			}
		}
		return true;// 활주로 길이만큼 좌표값이 이어지면
	}

	private static int isBuild(int r) {
		for (int i = 1; i < map.length; i++) {
			if (Math.abs(map[r][i - 1] - map[r][i]) > 1) {// 경사로를 건설하면 각각칸사이의 값들은 1차이가 나므로 1차이가안나오면 활주로 건설불가
				return 0;
			}
		}
		return 1;
	}

	private static void newHeightR(int r, int c, int height, int len) {
		for (int i = c; i < len + c; i++) {
			map[r][i] = height;
		}
	}

	private static boolean hwalR(int height, int r, int c, int len) {
		for (int i = c; i < len + c; i++) {
			if (i >= N || map[r][i] != height) {
				return false;// 활주로 길이만큼 좌표값이 이어지지않으면
			}
		}
		return true;// 활주로 길이만큼 좌표값이 이어지면

	}
}
