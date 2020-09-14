package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_블록이동하기 {
	static boolean visit[][];
	static int dr[] = { 1, 0, 0 };
	static int dc[] = { 0, -1, 1 };
	static int Ans;

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		int answer = 0;
		visit = new boolean[5][5];
		Ans = 0;
		bfs(0, 0, 0, 1, board);
		System.out.println(Ans);

	}

	private static void bfs(int x, int y, int xf, int yf, int[][] board) {
		Queue<Point> que = new LinkedList();
//		visit[xf][yf] = true;

		que.add(new Point(xf, yf, x, y, 0, 0));
		while (!que.isEmpty()) {
			Point p = que.poll();
			board[p.x][p.y] = 2;
			board[p.xb][p.yb] = 2;
			if (p.x == 4 && p.y == 4) {
				Ans = Math.min(Ans, p.cnt);
				System.out.println(p.cnt);
			}
			for (int k = 0; k < 3; k++) {
				int nr = p.x + dr[k];
				int nc = p.y + dc[k];
				if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && board[nr][nc] == 0) {
					if (p.before_dir == k) {
						if (p.xb + 1 >= 0 && p.xb + 1 < 5)
							que.add(new Point(nr, nc, p.xb + 1, p.yb, k, p.cnt + 1));
					} else {
						if (dirChk(p.xb, p.yb, board, k, p.before_dir))
							que.add(new Point(nr, nc, p.x, p.y, k, p.cnt + 1));
					}
				}
			}
		}
	}

	private static boolean dirChk(int xb, int yb, int[][] board, int dir, int pre_dir) {
		int nr = 0;
		if (pre_dir == 0) {
			if (dir == 1) {
				nr = yb - 1;
			} else if (dir == 2) {
				nr = yb + 1;
			}
			if (nr >= 0 && nr < 5 && board[xb][nr] == 1)
				return false;
		} else {
			nr = xb + 1;
			if (nr >= 0 && nr < 5 && board[nr][yb] == 1)
				return false;
		}
		return true;
	}

	static class Point {
		int x, y;
		int xb, yb;
		int before_dir;
		int cnt;

		Point(int x, int y, int xb, int yb, int before_dir, int cnt) {
			this.x = x;
			this.y = y;
			this.xb = xb;
			this.yb = yb;
			this.before_dir = before_dir;
			this.cnt = cnt;

		}
	}

}
