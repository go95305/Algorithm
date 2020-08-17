package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2583_영역구하기 {
	static int N, M, K;
	static int ar[][];
	static boolean[][] v;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int cnt;
	static int size;
	static ArrayList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();// 열
		N = sc.nextInt();// 행
		K = sc.nextInt();// 사각형의 범위를 정하는 변수
		ar = new int[N][M];
		v = new boolean[N][M];
		size = 0;// 직사각형을 제외한 부분의 개수
		list = new ArrayList<Integer>();
		for (int i = 0; i < K; i++) {
			int bx = sc.nextInt();// 0
			int by = sc.nextInt();// 2
			int ax = sc.nextInt();// 4
			int ay = sc.nextInt();// 4
			for (int j = bx; j < ax; j++) {// 0~4
				for (int t = by; t < ay; t++) {// 2~4
					ar[j][t] = 1;
				}
			}
		}

		cnt = 1;// 각 부분의 넓이를 구하기 위해 cnt를 1부터 시작
		for (int i = M - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (!v[j][i] && ar[j][i] == 0) {
					bfs(j, i);
					size++;// bfs를 한 번 씩 하고 올때마다 size++
					list.add(cnt);// 나중에 오름차순 정렬을 위해 list에 넣는다.
					cnt = 1;// 다시 bfs를 사용하기위해 cnt를 초기화
				}
			}
		}
		Collections.sort(list);
		System.out.println(size);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	private static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList();
		v[x][y] = true;
		que.add(new Point(x, y));
		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				// nr nc 좌표가 배열 내부에 있고 방문한적이 없고 배열값이 0이면 이동한다.
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && ar[nr][nc] == 0) {
					v[nr][nc] = true;
					que.add(new Point(nr, nc));
					cnt++;// 한 칸한칸 이동할때마다 ++해준다.(넓이 계산)
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
