package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3055탈출 {
	static int R, C;
	static char map[][];
	static boolean v[][][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int Ans;
	static boolean flag;
	static int cnt;
	static Queue<Point> gosum = new LinkedList<Point>();
	static Queue<Point> water = new LinkedList<Point>();

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		int x = 0;
		int y = 0;

		map = new char[R][C];
		v = new boolean[2][R][C];
		for (int i = 0; i < R; i++) {
			String tmp = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'S') {
					gosum.add(new Point(i, j));
				}
				if (map[i][j] == '*') {
					water.add(new Point(i, j));
				}
			}
		}
		flag = false;
		cnt = 0;
		bfs();
		if (!flag) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(cnt);
		}

	}

	private static void bfs() {

		int len = 0;
		while (true) {
			len = water.size();
			for (int i = 0; i < len; i++) {
				Point wat = water.poll();
				for (int k = 0; k < 4; k++) {
					int nr = wat.r + dr[k];
					int nc = wat.c + dc[k];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && (map[nr][nc] == 'S' || map[nr][nc] == '.')) {
						map[nr][nc] = '*';
						water.add(new Point(nr, nc));
					}
				}
			}
			len = gosum.size();
			for (int i = 0; i < len; i++) {
				Point go = gosum.poll();
				if (map[go.r][go.c] == 'D') {
					flag = true;
					break;
				}
				for (int k = 0; k < 4; k++) {
					int nr = go.r + dr[k];
					int nc = go.c + dc[k];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {

						if (map[nr][nc] != 'D') {
							map[nr][nc] = 'S';
						}
						gosum.add(new Point(nr, nc));
					}
				}
			}
			if (flag || gosum.isEmpty()) {
				break;
			}
			cnt++;
		}
	}

}
