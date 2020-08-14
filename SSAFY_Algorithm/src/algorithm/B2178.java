package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {
	static int[][] map;
	static boolean[][] v;
	static int max = 0;
	static int N, M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[M][N];
		v = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			String[] tmp = sc.next().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		bfs(0, 0, 1);
		System.out.println(max);

	}

	private static void bfs(int x, int y, int cnt) {
		Queue<Point> Q = new LinkedList();
		Q.add(new Point(x, y, cnt));
		v[x][y] = true;
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			if (p.r == M - 1 && p.c == N - 1) {
				if (max < p.cnt) {
					max = p.cnt;
				}
			}
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] == 1) {
					if (!v[nr][nc]) {
						v[nr][nc] = true;
						cnt = p.cnt + 1;
						Q.add(new Point(nr, nc, cnt));
					}
				}
			}
		}
	}

	static class Point {
		int r, c, cnt;

		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
