package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3085_사탕게임 {
	static int N;
	static char ar[][];
	static boolean v[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ar = new char[N][N];

		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < N; j++) {
				ar[i][j] = tmp.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					bfs(i, j, ar[i][j]);
				}
			}
		}

	}

	private static void bfs(int x, int y, char c) {
		int cnt = 0;
		boolean flag = true;
		Queue<Point> que = new LinkedList();
		v[x][y] = true;
		que.add(new Point(x, y));
		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && ar[nr][nc] == c) {
					que.add(new Point(nr, nc));
					cnt++;
				} else {
					flag = false;
				}
			}
		}
		if (flag) {
			
		}

	}

	static class Point {
		int r;
		int c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
