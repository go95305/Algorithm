package algorithm;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2206_벽부수고이동하기{
	static int N;
	static int M;
	static int ar[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean v[][][];
	static int Max;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ar = new int[N][M];
		v = new boolean[2][N][M];
		Max = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < M; j++) {
				ar[i][j] = tmp.charAt(j) - '0';
			}
		}
		flag = false;
		bfs(0, 0, 1, 1);
		if (flag == false) {
			System.out.println(-1);
		} else {
			System.out.println(Max);
		}
	}

	private static void bfs(int x, int y, int wall, int cnt) {
		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(x, y, wall, cnt));
		v[wall][x][y] = true;
		while (!que.isEmpty()) {
			Point p = que.poll();
			if (p.r == N - 1 && p.c == M - 1) {
				if (Max > p.cnt) {
					Max = p.cnt;
					flag = true;
				}
				return;
			}
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[p.wall][nr][nc]) {
					if (ar[nr][nc] == 0) {
						que.add(new Point(nr, nc, p.wall, p.cnt + 1));
						v[p.wall][nr][nc] = true;

					} else {
						if (p.wall == 1) {
							que.add(new Point(nr, nc, p.wall - 1, p.cnt + 1));
							v[p.wall][nr][nc] = true;
						}
					}
				}
			}
		}
	}

	static class Point {
		int r;
		int c;
		int wall;
		int cnt;

		Point(int r, int c, int wall, int cnt) {
			this.r = r;
			this.c = c;
			this.wall = wall;
			this.cnt = cnt;
		}
	}

}
