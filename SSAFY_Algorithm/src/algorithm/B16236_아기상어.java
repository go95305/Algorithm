package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16236_아기상어 {
	static int N;
	static int map[][];
	static int babySize = 0;
	static boolean v[][][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int Ans;
	static int fish;

	static class Point {
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", eat=" + eat + ", visit=" + visit + "]";
		}

		int r, c, cnt, eat, visit;

		public Point(int r, int c, int cnt, int eat, int visit) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.eat = eat;
			this.visit = visit;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		v = new boolean[100][N][N];
		int stx = 0;
		int sty = 0;
		fish = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] > 0 && map[i][j] != 9) {
					fish++;
				}
				if (map[i][j] == 9) {
					stx = i;
					sty = j;
					map[i][j]=0;
				}
			}
		}

		babySize = 2;// 초기 아기상어 크기
		Ans = Integer.MAX_VALUE;

		bfs(stx, sty, 0);
		System.out.println(Ans);
	}

	private static void bfs(int x, int y, int cnt) {
		Queue<Point> que = new LinkedList<Point>();
		v[0][x][y] = true;
		que.add(new Point(x, y, cnt, 0, 0));
		while (!que.isEmpty()) {
			Point p = que.poll();
//			System.out.println("현재 먹은 물고기 수 :"+p.eat);
			if (fish == p.eat) {
				Ans = Math.min(Ans, p.cnt);
			}
			if (p.eat == babySize) {
				babySize++;
			}
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 
						&& nc < N && !v[p.visit][nr][nc] 
								&& map[nr][nc] <= babySize) {
					if (map[nr][nc] < babySize) {// 물고기를 먹으면
						if (map[nr][nc] != 0) {// 0이아니면 물고기 이므로 먹는다.
							v[p.visit + 1][nr][nc] = true;
							System.out
									.println("물고기 크기(" + babySize + ") " + (nr) + "," + (nc) + "의 물고기를 먹는다." + (p.visit+1));
//							map[nr][nc] = 0;
							que.add(new Point(nr, nc, p.cnt + 1, p.eat + 1, p.visit + 1));
						} else {// 0이면 물고기가 없으므로 그대로 통과
							v[p.visit][nr][nc] = true;
							System.out.println("물고기 크기:(" + babySize + ") " + (nr) + "," + (nc) + "는 물고기가 없으므로 패스."+p.visit);
							que.add(new Point(nr, nc, p.cnt + 1, p.eat, p.visit));
						}
					} else {// 물고기를 안먹을 경우
						System.out.println("물고기 크기:(" + babySize + ") " + (nr) + "," + (nc) + "같은 크기이므로 패스."+p.visit);
						v[p.visit][nr][nc] = true;
						que.add(new Point(nr, nc, p.cnt + 1, p.eat, p.visit));
					}
				}
			}
		}
	}
}
