package algorithm;

import java.util.Scanner;

public class B17070_파이프옮기기1 {
	static int dr[] = { 0, 1, 1 };// 3방향으로만 이동
	static int dc[] = { 1, 1, 0 };// 3방향으로만 이동
	static int N;
	static int ar[][];
	static boolean v[][];
	static int cnt;// 이동경로 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ar = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ar[i][j] = sc.nextInt();
			}
		}
		v = new boolean[N][N];
		v[0][0] = true;// 0,0은 true로 하고 시작
		cnt = 0;
		dfs(0, 1, 0, 0);// 현재 좌표와 이전좌표를 보낸다.
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, int prev_x, int prev_y) {
		// 현재 좌표가 배열의 끝에 도달하면 cnt++해주고 종료한다.
		if (x == N - 1 && y == N - 1) {
			cnt++;
			return;
		}
		v[x][y] = true;
		for (int k = 0; k < 3; k++) {
			int nr = x + dr[k];
			int nc = y + dc[k];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
				if (k == 0) { // 오른쪽에 벽이 있을경우
					if (ar[nr][nc] == 1) {
						continue;
					}
				} else if (k == 1) {// 인접 3방향에 벽이 있을경우
					if (ar[nr][nc] == 1 || ar[nr - 1][nc] == 1 || ar[nr][nc - 1] == 1) {
						continue;
					}
				} else {
					if (ar[nr][nc] == 1) {// 아래에에 벽이 있을경우
						continue;
					}
				}
				if (prev_x + 1 == x && prev_y + 1 == y) {// 대각선인경우
					dfs(nr, nc, x, y);
					v[nr][nc] = false;
				} else if (prev_x + 1 == x && prev_y + 1 != y && x != nr) {// 수직인경우
					dfs(nr, nc, x, y);
					v[nr][nc] = false;
				} else if (prev_x + 1 != x && prev_y + 1 == y && y != nc) {// 수평인경우
					dfs(nr, nc, x, y);
					v[nr][nc] = false;
				}
			}
		}
	}
}
