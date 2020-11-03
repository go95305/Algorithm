package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1953_탈주범검거 {
	static int N, M;
	static int map[][];
	static int time;
	static int Ans;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean v[][];

	static class Point {
		int r, c, cnt;

		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			v = new boolean[N][M];
			int x = sc.nextInt();// 맨홀의 위치
			int y = sc.nextInt();// 맨홀의 위치
			time = sc.nextInt();

			Ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}

		}
	}

}
