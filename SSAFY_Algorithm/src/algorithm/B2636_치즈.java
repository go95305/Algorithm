package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2636_치즈 {
	static int N, M;
	static int map[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean v[][];
	static boolean flag;

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int cnt = chzCnt();
		int ans = 0;
		int time = 0;
		v = new boolean[N][M];
		while (true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						v[i][j] = true;
						bfs(i, j);
						v[i][j] = false;
						if (flag) {
							map[i][j] = 2;
							flag = false;
						}
						v = new boolean[N][M];
					}
				}
			}
			melt();
			time++;
			int tmp=chzCnt();
			if (tmp== 0)
				break;
			else
				cnt= tmp;

		}
		System.out.println(time);
		System.out.println(cnt);
	}

	private static void melt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2)
					map[i][j] = 0;
			}
		}
	}

	private static int chzCnt() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					cnt++;
			}
		}
		return cnt;
	}

	private static void bfs(int r, int c) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(r, c));
		while (!que.isEmpty()) {
			Point p = que.poll();
			if (p.r == N - 1 || p.r == 0 || p.c == M - 1 || p.c == 0) {
				flag = true;
				return;
			}
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 0) {
					v[nr][nc] = true;
					que.add(new Point(nr, nc));
				}
			}
		}

	}
}
