package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1194_달이차오른다가자 {
	static int N, M;
	static char map[][];
	static boolean v[][][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int bit;
	static int Ans;

	static class Point {
		int r, c, bit, v, cnt;

		Point(int r, int c, int bit, int v, int cnt) {
			this.r = r;
			this.c = c;
			this.bit = bit;
			this.v = v;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		int stx = 0;
		int sty = 0;
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == '0') {
					stx = i;
					sty = j;
				}
			}
		}
		Ans = Integer.MAX_VALUE;
		bit = 0;
		v = new boolean[100][N][M];
		bfs(stx, sty, 0);
		if (Ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(Ans);
	}

	private static void bfs(int r, int c, int bit) {
		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(r, c, 0, 0, 0));
		v[0][r][c] = true;
		while (!que.isEmpty()) {
			Point p = que.poll();
			if (map[p.r][p.c] == '1') {
				Ans = Math.min(Ans, p.cnt);
				return;
			}
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[p.v][nr][nc] && map[nr][nc] != '#') {
					// 소문자 칸이면
					if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						v[p.v][nr][nc] = true;

						que.add(new Point(nr, nc, p.bit | (1 << (map[nr][nc] - 'a')), p.v | (1 << (map[nr][nc] - 'a')),
								p.cnt + 1)); // 비트마스킹

						// 현재칸은 방문을 푼다.
					}
					// 대문자 칸이면
					else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
						if ((p.bit & ((1 << (map[nr][nc] + 32) - 'a'))) == (1 << (map[nr][nc] + 32) - 'a')) {
							v[p.v][nr][nc] = true;
							que.add(new Point(nr, nc, p.bit, p.v, p.cnt + 1));

						}
					}
					// 일반 .이거나 1인 칸이면
					else {
						v[p.v][nr][nc] = true;
						que.add(new Point(nr, nc, p.bit, p.v, p.cnt + 1));

					}
				}
			}
		}
	}
}
