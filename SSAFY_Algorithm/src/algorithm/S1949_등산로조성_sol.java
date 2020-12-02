package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1949_등산로조성_sol {
	static int N, K, map[][], max, top;
	static boolean[][] visited;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			visited = new boolean[N][N];
			max = 0;
			top = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (top < map[i][j])
						top = map[i][j];
				}
			}
			findTop();
			System.out.println("#" + t + " " + max);
		}

	}

	private static void findTop() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == top)
					makeLoad(i, j, map[i][j], false, 1);
			}
		}
	}

	private static void makeLoad(int r, int c, int height, boolean isUsed, int distance) {
		max = Math.max(max, distance);
		visited[r][c] = true;
		int nr, nc;
		for (int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
				if (height > map[nr][nc]) {// 현위치기준으로 내리막
					makeLoad(nr, nc, map[nr][nc], isUsed, distance + 1);
				} else if (!isUsed && map[nr][nc] - K < height) { // 현위치기준으로 평지이거나 오르막: 깍아서 갈수 있는지 체크
					makeLoad(nr, nc, height - 1, true, distance + 1);// height-1을 해줘야 최대한 갈수 있다.
				}
			}
		}
		visited[r][c] = false;
	}
}
