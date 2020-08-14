package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1012 {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[][] map;
	static boolean[][] v;
	static int T, Ans, M, N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 0; test_case < T; test_case++) {
			Ans = 0;
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][M];
			v = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
			}
//			print(map);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 1) {
						Ans++;
						bfs(r, c);
					}
				}
			}
			System.out.printf("%d\n",Ans);
		}
	}

	private static void bfs(int r, int c) {
		Queue<Point> Q = new LinkedList();
		Q.add(new Point(r, c));
		map[r][c] = 0;
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1) {
					map[nr][nc] = 0;
					Q.add(new Point(nr, nc));
				}
			}
		}
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
