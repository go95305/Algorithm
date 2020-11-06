package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1868_파핑파핑지뢰찾기 {
	static int N;
	static char map[][];
	static int Ans[][];
	static boolean v[][];
	static ArrayList<Point> list;
	static int dr[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dc[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			list = new ArrayList<Point>();
			v = new boolean[N][N];
			map = new char[N][N];
			Ans = new int[N][N];
			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == '*') {
						list.add(new Point(i, j));
					}
				}
			}

			for (int i = 0; i < list.size(); i++) {
				bfs(list.get(i).r, list.get(i).c);
//				check
			}
		}
	}

	private static void bfs(int r, int c) {
		int cnt = 0;
		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(r, c));
		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int k = 0; k < 8; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '*') {
					cnt++;
				}
			}
			if (cnt == 0) {
				for (int k = 0; k < 8; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != '*' && !v[nr][nc]) {
						que.add(new Point(nr, nc));
					}
				}
			} else {
				v[r][c] = true;
			}
		}
	}
}
