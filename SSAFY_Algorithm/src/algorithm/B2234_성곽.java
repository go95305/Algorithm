package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2234_성곽 {
	static int n, m;
	static int map[][];
	static boolean v[][];
	static int dr[] = { 0, -1, 0, 1 };// 서,북,동,남
	static int dc[] = { -1, 0, 1, 0 };
	static int room, max, room2;
	static int roomChk;
	static int wall;

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
		v = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		room = 0;
		max = 0;
		room2 = 0;
		roomChk = 1;
		wall = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[i][j]) {
					bfs(i, j);
					room++;// 방의 개수
					room2 = Math.max(room2, roomChk);
					roomChk = 1;
				}
			}
		}
		roomChk=1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int bit = 1; bit < 8; bit<<=1) {
					if ((map[i][j] & bit) != 0) {
						v = new boolean[m][n];
						map[i][j]-=bit;
						bfs(i,j);
						max=Math.max(max, roomChk);
						map[i][j]+=bit;
						roomChk=1;
					}
				}
			}
		}

		System.out.println(room);
		System.out.println(room2);
		System.out.println(max);
	}


	private static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<Point>();
		v[x][y] = true;
		que.add(new Point(x, y, 1, 1));
		while (!que.isEmpty()) {
			Point p = que.poll();
			int bit=1;
			int move = map[p.r][p.c];
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < m && nc >= 0 && nc < n && !v[nr][nc]) {
					if ((move & (1 << k)) == 0) {// 벽이아닌경우
						v[nr][nc] = true;
						que.add(new Point(nr, nc, p.wall, p.cnt + 1));
						roomChk++;
					}
				}
				bit<<=1;
			}
		}
	}
}
