package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S5656_벽돌깨기_sol2 {

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	private static int N, W, H, min;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(in.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];
			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			go(0, map);
			System.out.println("#" + t + " " + min);
		}
	}

	// i 번째 구슬을 떨어뜨리기
	private static boolean go(int count, int[][] map) {// 던져진 구슬의 개수, 이전 구슬까지의 2차원배열
		int result = getRemain(map);
		if (result == 0) {
			min = 0;
			return true;
		}

		if (count == N) {
			// 남아있는 벽돌의 개수 구하여 최소값 갱신
			if (min > result)
				min = result;

			return false;
		}

		int[][] newMap = new int[H][W];
		// 모든 열에 떨어뜨리는 시도
		for (int c = 0; c < W; c++) {

			int r = 0;
			while (r < H && map[r][c] == 0)
				++r;

			if (r == H)
				continue;
			// 이전 구슬 상태로 배열 복사하여 초기화
			copy(map, newMap);
			// 터트리기
			boom(newMap, r, c);
			// 벽돌 내리기
			down(newMap);
			// 다음 구슬 처리
			if (go(count + 1, newMap))
				return true;
		}
		return false;

	}

	private static void boom(int[][] map, int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		if (map[r][c] > 1) {
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0;// 벽돌 제거 처리(방문처리);

		while (!queue.isEmpty()) {
			Point p = queue.poll();// 벽돌 꺼내기
			if (p.cnt == 1)
				continue;

			for (int d = 0; d < 4; d++) {
				int nr = p.r, nc = p.c;
				for (int k = 1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0) {
						if (map[nr][nc] > 1) {
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
		}
	}

	private static void down(int[][] map) {
		for (int c = 0; c < W; c++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int r;
			for (r = H - 1; r >= 0; r--) {
				if (map[r][c] > 0) {
					list.add(map[r][c]);
					map[r][c]=0;
				}
			}
			r=H;
			for (int b : list) {
				map[--r][c]=b;
			}
			list.clear();
		}
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0)
					++count;
			}
		}
		return count;
	}
}
