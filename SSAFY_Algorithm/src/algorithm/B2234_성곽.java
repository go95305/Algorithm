package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2234_성곽 {
	static int n, m;
	static int map[][];
	static boolean v[][][];
	static int dr[] = { 0, -1, 0, 1 };// 서,북,동,남
	static int dc[] = { -1, 0, 1, 0 };
	static int room, max, room2;
	static int roomChk;

	static class Point {
		int r, c, wall, cnt;

		Point(int r, int c, int wall, int cnt) {
			this.r = r;
			this.c = c;
			this.wall = wall;

			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[m][n];
		v = new boolean[2][m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		room = 0;
		max = 0;
		room2 = 0;
		roomChk = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[0][i][j]) {
					bfs(i, j);
					for (int j2 = 0; j2 < m; j2++) {
						System.out.println(Arrays.toString(v[1][j2]));
					}
					System.out.println();
					room++;// 방의 개수
//					room2 = Math.max(room2, roomChk);
//					roomChk = 0;
					boolReset();
				}
			}
		}
		System.out.println(room);
//		System.out.println(room2);
//		System.out.println(max);
	}

	private static void boolReset() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (v[1][i][j] == true) {
					v[1][i][j] = false;
				}
			}
		}

	}

	private static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<Point>();
		v[0][x][y] = true;
		que.add(new Point(x, y, 1, 1));
		while (!que.isEmpty()) {
			Point p = que.poll();
			int move = map[p.r][p.c];
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < m && nc >= 0 && nc < n && !v[p.wall][nr][nc]) {
					if ((move & (1 << k)) != 0) {// bit check해서 0이 아니면 벽인거다
						if (p.wall == 1) {// 벽이어도 1번은 뚫을 수 있다.
							v[p.wall][nr][nc] = true;
							que.add(new Point(nr, nc, p.wall - 1, p.cnt + 1));
						}
					} else {// 벽이 아니면
						v[p.wall][nr][nc] = true;
						que.add(new Point(nr, nc, p.wall, p.cnt + 1));// 그대로 이동
					}
				}
			}
		}
	}

}
