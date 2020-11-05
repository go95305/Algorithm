package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500_테트로미노 {
	static int map[][];
	static boolean v[][];
	static int Ans;
	static int N, M;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int moveR;
	static int moveC;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		v = new boolean[N][M];
		Ans = 0;
		moveR = 0;
		moveC = 0;
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				v[j][k] = true;
				dfs(j, k, 0, map[j][k]);
				v[j][k] = false;
			}
		}
		System.out.println(Ans);
	}

	private static void dfs(int r, int c, int cnt, int sum) {
		if (cnt == 1) {
			moveR = r;
			moveC = c;
		}

		// 종료 조건
		if (cnt == 3) {
			Ans = Math.max(Ans, sum);
			moveTo_sec(0, moveR, moveC, sum - map[r][c]);
			return;
		}

		// 탐색
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]) {
				v[nr][nc] = true;
				dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
				v[nr][nc] = false;
			}
		}
	}

	private static void moveTo_sec(int idx, int r, int c, int sum) {
		if (idx == 1) {
			Ans = Math.max(Ans, sum);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]) {
				moveTo_sec(idx + 1, nr, nc, sum + map[nr][nc]);
			}
		}
	}

}
