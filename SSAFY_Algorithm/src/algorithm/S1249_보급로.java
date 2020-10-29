package algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class S1249_보급로 {
	static int N;
	static int map[][];
	static boolean v[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int Ans;

	static class Point implements Comparable<Point> {
		int r, c, time;

		Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;

		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", time=" + time + "]";
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp.charAt(j) - '0';
				}
			}
			Ans = Integer.MAX_VALUE;
			v = new boolean[N][N];
			bfs(0, 0, 0);
			System.out.printf("#%d %d\n",tc,Ans);
		}
	}

	private static void bfs(int r, int c, int time) {
		PriorityQueue<Point> que = new PriorityQueue<Point>();
		que.add(new Point(r, c, time));
		v[r][c] = true;
		while (!que.isEmpty()) {
			Point p = que.poll();
//			System.out.println("p.r: "+p.r+"p.c: "+p.c+"time: "+p.time);
			if (p.r == N - 1 && p.c == N - 1) {
				Ans = Math.min(Ans, p.time);
			}
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
					v[nr][nc]=true;
					que.add(new Point(nr, nc, p.time + map[nr][nc]));
				}
			}
		}

	}

}
