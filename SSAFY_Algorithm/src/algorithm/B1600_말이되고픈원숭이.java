package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1600_말이되고픈원숭이 {
	static int K, W, H;
	static int map[][];
	static boolean v[][][];
	static int dr[] = { -1, 1, 0, 0, -2, -1, -2, -1, 2, 1, 2, 1 };
	static int dc[] = { 0, 0, -1, 1, -1, -2, 1, 2, -1, -2, 1, 2 };
	static int Ans;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		Ans = Integer.MAX_VALUE;
		
		v = new boolean[K+1][H][W];
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(0, 0, K, 0));
		v[K][0][0] = true;
		while (!que.isEmpty()) {
			Point p = que.poll();
			if (p.r == H - 1 && p.c == W - 1) {
				Ans=Math.min(Ans, p.cnt);
			}
			/** 현재 k값이 0보다 크면 말 처럼 이동가능, 아니면 원숭이처럼 인접만 가능 */
			for (int i = 0; i < (p.k > 0 ? 12 : 4); i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				int nk = i < 4 ? p.k : p.k - 1;
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && !v[nk][nr][nc]&&map[nr][nc]!=1) {
					v[nk][nr][nc]=true;
					que.add(new Point(nr, nc, nk, p.cnt + 1));
				}
			}
		}
		if (Ans==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(Ans);
		}

	}

	static class Point {
		int r, c, k, cnt;

		Point(int r, int c, int k, int cnt) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}

}
