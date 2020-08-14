package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2468안전영역 {
	static int ar[][];
	static boolean v[][];
	static int N;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ar = new int[N][N];
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ar[i][j] = sc.nextInt();
			}
		}
		for (int day = 1; day <= 100; day++) {
			v = new boolean[N][N];
			int cnt = 0;
			chk(day);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j] && ar[i][j] != day) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			if (max < cnt) {
				max = cnt;
			}
		}
		System.out.println(max);
	}

	private static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(x, y));
		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.x + dr[k];
				int nc = p.y + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
					v[nr][nc] = true;
					que.add(new Point(nr, nc));
				}
			}
		}
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void chk(int day) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (ar[i][j] <= day) {
					v[i][j] = true;
				}
			}
		}
	}

}
