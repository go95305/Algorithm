package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2234_성곽 {
	static int n, m;
	static int map[][];
	static boolean v[][][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int room, max, room2;

	static class Point {
		int r, c, cnt, wall;

		Point(int r, int c, int cnt, int wall) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.wall = wall;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[m][n];
		v = new boolean[2][m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		room = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[1][i][j]) {
					bfs(i, j);
					room++;
				}
			}
		}
		System.out.println(room);
		System.out.println(max);

	}

	private static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<Point>();
		v[1][x][y] = true;
		que.add(new Point(x, y, 0, 1));
		while (!que.isEmpty()) {
			Point p = que.poll();
			Math.max(max, p.cnt);
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (check(nr, nc, p.wall) && bitChk(p.r, p.c, nr, nc)) {
					v[p.wall][nr][nc] = true;
					que.add(new Point(nr, nc, p.cnt + 1, p.wall));
				}
			}
		}
	}

	private static void bfs2(int x, int y) {
		Queue<Point> que = new LinkedList<Point>();
		v[1][x][y] = true;
		que.add(new Point(x, y, 0, 1));
		while (!que.isEmpty()) {
			Point p = que.poll();
			Math.max(max, p.cnt);
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (check(nr, nc, p.wall)) {
					if (bitChk(p.r, p.c, nr, nc)) {
						v[p.wall][nr][nc] = true;
						que.add(new Point(nr, nc, p.cnt + 1, p.wall));
					} else {
						if (p.wall == 1) {
							v[p.wall - 1][nr][nc] = true;
							que.add(new Point(nr, nc, p.cnt + 1, p.wall - 1));
						}
					}
				}
			}
		}
	}

	private static boolean bitChk(int r, int c, int nr, int nc) {
		int flag = 0;

		if ((map[nr][nc] & (15 - map[r][c])) > 0) {
			return true;
		}
		return false;
	}

	private static boolean check(int nr, int nc, int wall) {
		if (nr >= 0 && nr < m && nc >= 0 && nc < n && !v[wall][nr][nc]) {
			return true;
		}
		return false;
	}
}
