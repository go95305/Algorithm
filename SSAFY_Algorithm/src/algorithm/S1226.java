package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1226 {
	static int endR;
	static int endC;
	static boolean v[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int ar[][];
	static int Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int num = sc.nextInt();
			Ans = 0;//종료지점에 도착하면 1, 아니면 0을 반환
			int startR = 0;// 시작 x좌표
			int startC = 0;// 시작 y좌표
			endR = 0;// 종료 x좌표
			endC = 0;// 종료 y좌표
			ar = new int[16][16];//테케 배열
			v = new boolean[16][16];//visit했는지 확인하는 boolean배열
			for (int i = 0; i < 16; i++) {//값 입력
				String tmp = sc.next();
				for (int j = 0; j < 16; j++) {
					ar[i][j] = tmp.charAt(j) - '0';
					if (ar[i][j] == 2) {
						startR = i;
						startC = j;
					}
				}
			}
			bfs(startR, startC);//시작좌표(2)에서 bfs를 시작
			System.out.printf("#%d %d\n", test_case, Ans);
		}
	}

	private static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList();
		v[x][y] = true;
		que.add(new Point(x, y));
		while (!que.isEmpty()) {
			Point p = que.poll();
			if (ar[p.r][p.c] == 3) {//좌표값이 3이면 Ans를 1로 해준다.아니면 0이다.
				Ans = 1;
			}
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && !v[nr][nc] && (ar[nr][nc] == 0 || ar[nr][nc] == 3)) {
					v[nr][nc] = true;
					que.add(new Point(nr, nc));
				}
			}
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
