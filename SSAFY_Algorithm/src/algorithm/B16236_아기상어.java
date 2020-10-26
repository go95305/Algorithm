package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16236_아기상어 {
	static int N;
	static ArrayList<Point> list;
	static ArrayList<Point> fishlist;
	static int map[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int Ans;
	static int sharkSize;
	static int sharkRN;
	static int sharkCN;
	static boolean v[][];
	static int move;
	static int minR, minC, minIdx, minCnt;

	static class Point {
		int r, c, size, cnt;

		Point(int r, int c, int size, int cnt) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		list = new ArrayList<Point>();

		sharkRN = 0;
		sharkCN = 0;
		int eaten=0;
		sharkSize = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					sharkRN = i;
					sharkCN = j;
				}
				if (map[i][j] > 0 && map[i][j] < 9) {
					list.add(new Point(i, j, map[i][j], 0));
				}
			}
		}
		minR = minC = minIdx = 0;
		move = 0;
		int dist=0;
		while (!list.isEmpty()) {
			minCnt = Integer.MAX_VALUE;
			for (int i = 0; i < list.size(); i++) {
				v = new boolean[N][N];		
				if (list.get(i).size < sharkSize) {
					bfs(list.get(i).r, list.get(i).c,i);
				}
			}
			if (minCnt == Integer.MAX_VALUE)
				break;
			map[sharkRN][sharkCN]=0;
			sharkRN=minR;
			sharkCN=minC;
			eaten++;
			if (eaten == sharkSize) {
				sharkSize++;
				eaten=0;
			}
			dist+=move;
			list.remove(minIdx);
		}
		System.out.println(dist);
	}

	private static void bfs(int fishR, int fishC,int idx) {
		Queue<Point> que = new LinkedList<Point>();
		v[sharkRN][sharkCN]=true;
		que.add(new Point(sharkRN, sharkCN, sharkSize, 0));
		while (!que.isEmpty()) {
			Point p = que.poll();
			if (p.r == fishR && p.c == fishC) {
				if (minCnt > p.cnt) {
					minCnt = p.cnt;
					minR = p.r;
					minC = p.c;
					move = p.cnt;
					minIdx = idx;
				} else if (minCnt == p.cnt) {
					if (minR == p.r) {
						if (minC > p.c) {
							move = p.cnt;
							minR = p.r;
							minC = p.c;
							minIdx = idx;
						}
					} else if (minR > p.r) {
						minR = p.r;
						minC = p.c;
						move = p.cnt;
						minIdx = idx;
					}
				}
				return;
			}
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] <=sharkSize && !v[nr][nc]) {
					v[nr][nc] = true;
					que.add(new Point(nr, nc, sharkSize, p.cnt + 1));
				}
			}
		}

	}

}
