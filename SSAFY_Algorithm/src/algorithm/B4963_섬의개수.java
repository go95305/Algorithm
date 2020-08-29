package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B4963_섬의개수 {
	static int W, H;
	static int map[][];
	static int Ans;
	static boolean v[][];
	static int dr[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dc[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream(
//				"C:\\Users\\고유창\\git\\Algorithmhub\\SSAFY_Algorithm\\src\\algorithm\\testcase.txt"));
		Scanner sc = new Scanner(System.in);

		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();
			if (W == 0 && H == 0) {
				break;
			}
			Ans = 0;
			map = new int[H][W];
			v = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1 && !v[i][j]) {
						bfs(i, j);
						Ans++;
					}
				}
			}
			System.out.println(Ans);
		}

	}

	private static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<Point>();
		v[x][y] = true;
		que.add(new Point(x, y));
		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int k = 0; k < 8; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && !v[nr][nc] && map[nr][nc] == 1) {
					map[nr][nc] = 0;
					que.add(new Point(nr, nc));
					v[nr][nc] = true;
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
}
