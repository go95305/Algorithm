package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1949_등산로조성 {
	static int map[][];
	static int N, K;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean v[][][];
	static int Ans;

	static class Point {
		int r, c, cnt, cut;

		Point(int r, int c, int cnt, int cut) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.cut = cut;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int highNum = 0;
			Ans = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (highNum < map[i][j])
						highNum = map[i][j];
				}
			}
			ArrayList<Point> list = new ArrayList<S1949_등산로조성.Point>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == highNum) {
						list.add(new Point(i, j, 0, 1));
					}
				}
			}

			v = new boolean[2][N][N];
			for (int i = 0; i < list.size(); i++) {
				v[1][list.get(i).r][list.get(i).c] = true;
				dfs(list.get(i).r, list.get(i).c, 1, 1);
				v[1][list.get(i).r][list.get(i).c] = false;
			}
			System.out.printf("#%d %d\n", tc, Ans);
		}
	}

	private static void dfs(int r, int c, int cnt, int cut) {
		Ans = Math.max(Ans, cnt);

		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[cut][nr][nc]) {
				if (map[nr][nc] >= map[r][c]) {
					
				}
			}
		}
	}
}
