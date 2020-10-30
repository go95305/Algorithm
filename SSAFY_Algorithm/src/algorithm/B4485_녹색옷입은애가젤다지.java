package algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B4485_녹색옷입은애가젤다지 {
	static int N;
	static int map[][];
	static boolean v[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int Ans;

	static class Point implements Comparable<Point> {
		int r, c, cost;

		Point(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while (true) {
			N = sc.nextInt();
			if (N == 0)
				break;
			map = new int[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			Ans = Integer.MAX_VALUE;
			bfs(0, 0, map[0][0]);
			System.out.printf("Problem %d: %d\n", tc, Ans);
			tc++;
		}
	}

	private static void bfs(int r, int c, int cost) {
		PriorityQueue<Point> que = new PriorityQueue<Point>();
		v[r][c] = true;
		que.add(new Point(r, c, cost));
		while (!que.isEmpty()) {
			Point p = que.poll();
			if (p.r == N - 1 && p.c == N - 1) {
				Ans = Math.min(Ans, p.cost);
			}
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
					v[nr][nc] = true;
					que.add(new Point(nr, nc, p.cost + map[nr][nc]));
				}
			}
		}

	}
}
