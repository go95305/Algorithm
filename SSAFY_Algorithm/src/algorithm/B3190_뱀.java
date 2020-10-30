package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3190_뱀 {
	static int N;
	static int map[][];

	static class Dir {
		int time;
		char dir;

		Dir(int time, char dir) {
			this.time = time;
			this.dir = dir;
		}
	}

	static class Tail {
		int r, c;

		Tail(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		int apple = sc.nextInt();
		for (int i = 0; i < apple; i++) {
			map[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
		}

		Queue<Dir> que = new LinkedList<Dir>();
		Queue<Tail> tail = new LinkedList<Tail>();
		int swtch = sc.nextInt();
		for (int i = 0; i < swtch; i++) {
			que.add(new Dir(sc.nextInt(), sc.next().charAt(0)));
		}
		// 진행
		// snake배열 초 마다 방향 전환
		int cnt = 0;
		int r = 0;
		int c = 0;
		int dir = 0;
		boolean v[][] = new boolean[N][N];
		v[0][0] = true;
		tail.add(new Tail(r, c));
		while (true) {
			cnt++;
			// 방향에 따라 r,c 이동
			if (dir == 0) {
				c++;
			} else if (dir == 1) {
				r++;
			} else if (dir == 2) {
				c--;
			} else if (dir == 3) {
				r--;
			}

			// 벽이든가 몸에 부딪치면 종료
			if ((r == -1 || r == N || c == -1 || c == N) || tailTouch(r, c, v, tail))
				break;
			v[r][c] = true;

			// 꼬리 붙이기
			v[r][c] = true;
			tail.add(new Tail(r, c));
			// 사과 있는지 확인
			if (map[r][c] == 0) {
				removeTail(tail, v);
			}

			// 방향 전환
			if (!que.isEmpty()) {
				if (cnt == que.peek().time) {
					// 큐에서 제거
					Dir d = que.poll();
					if (d.dir == 'D') {
						dir++;
						if (dir == 4)
							dir = 0;
					} else {
						dir--;
						if (dir == -1)
							dir = 3;
					}
				}
			}

			// 몇 초 경과
//			cnt++;
		}
		System.out.println(cnt);
	}

	private static void removeTail(Queue<Tail> tail, boolean[][] v) {
		Tail t = tail.poll();
		v[t.r][t.c] = false;
		map[t.r][t.c]=0;

	}

	private static boolean tailTouch(int r, int c, boolean[][] v, Queue<Tail> tail) {
		boolean flag = false;
		for (int i = 0; i < tail.size(); i++) {
			Tail t = tail.poll();
			if (t.r == r && t.c == c)
				flag = true;
			tail.add(t);
		}
		return flag;
	}

}
