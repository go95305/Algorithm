package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S7793_오나의여신님 {
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int N;
	static int M;
	static char arr[][];
	static boolean flag;
	static Queue<Point> fire;
	static Queue<Point> angel;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			fire = new LinkedList<Point>();
			angel = new LinkedList<Point>();
			arr = new char[N][M];
			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				for (int j = 0; j < M; j++) {
					arr[i][j] = tmp.charAt(j);
					if (arr[i][j] == '*') {
						fire.add((new Point(i, j)));
					} else if (arr[i][j] == 'S') {
						angel.add((new Point(i, j)));
					}
				}
			}
			flag = false;
			cnt = 0;
			bfs();
			if (flag) {
				System.out.printf("#%d %d\n", test_case, cnt);
			} else {
				System.out.printf("#%d %s\n", test_case, "GAME OVER");
			}
		}
	}

	private static void bfs() {

		Point p = null;
		while (true) {
			int len = fire.size();
			for (int i = 0; i < len; i++) {
				p = fire.poll();
				for (int k = 0; k < 4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && (arr[nr][nc] == 'S' || arr[nr][nc] == '.')) {
						fire.add(new Point(nr, nc));
						arr[nr][nc] = '*';
					}

				}
			}

			len = angel.size();
			for (int i = 0; i < len; i++) {
				p = angel.poll();
				if (arr[p.r][p.c] == 'D') {
					flag = true;
					break;
				}

				for (int k = 0; k < 4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && (arr[nr][nc] == '.' || arr[nr][nc] == 'D')) {
						if (arr[nr][nc] != 'D')
							arr[nr][nc] = 'S';
						angel.add(new Point(nr, nc));
					}
				}

			}
			if (flag || angel.isEmpty())
				break;
			cnt++;		
		}
	}

	static class Point {
		int r;
		int c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;

		}
	}
}
