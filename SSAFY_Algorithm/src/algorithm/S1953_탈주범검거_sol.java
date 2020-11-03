package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S1953_탈주범검거_sol {
	static int N, M, R, C, L, map[][];
	static int visited[][];
	// 상 하 우하:0123
	static String[] type = { null, "0312", "03", "12", "02", "32", "31", "01" };

	static int dr[] = { -1, 0, 0, 1 };
	static int dc[] = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					visited[i][j] = Integer.MAX_VALUE;
				}
			}

			dfs(R, C, 1);
			System.out.println("#" + t + " " + getCount());

		}

	}

	private static void dfs(int r, int c, int time) {
		visited[r][c] = time;
		if (time == L)
			return;
		String info = type[map[r][c]];
		int dir, nr, nc;
		for (int d = 0; d < info.length(); d++) {
			dir = info.charAt(d) - '0';
			nr = r + dr[dir];
			nc = c + dc[dir];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0
					&& type[map[nr][nc]].contains(Integer.toString(3 - dir)) && visited[nr][nc] > time) {
				dfs(nr, nc, time + 1);
			}
		}
	}

	private static int getCount() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] != Integer.MAX_VALUE)
					count++;
			}
		}
		return count;
	}

}
