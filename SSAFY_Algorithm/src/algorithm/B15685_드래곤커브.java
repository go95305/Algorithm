package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class B15685_드래곤커브 {
	static int N;
	static int map[][];
	static ArrayList<Integer> list;
	static ArrayList<Integer> newAdd;
	static int dr[] = { 0, -1, 0, 1 };
	static int dc[] = { 1, 0, -1, 0 };

	static int drChk[] = { 0, 1, 1 };
	static int dcChk[] = { 1, 1, 0 };
	static int Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[101][101];
		Ans = 0;
		for (int i = 0; i < N; i++) {
			list = new ArrayList<Integer>();
			int y = sc.nextInt();// 4
			int x = sc.nextInt();// 2
			int d = sc.nextInt();
			int g = sc.nextInt();
			list.add(d);
			map[x][y] = 1;
			int nr = x + dr[d];
			int nc = y + dc[d];
			map[nr][nc] = 1;
			dragonCurve(nr, nc, g, 0);
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1)
					if (sideChk(i, j))
						Ans++;
			}
		}
		System.out.println(Ans);
	}

	private static boolean sideChk(int r, int c) {
		int cnt = 0;
		for (int k = 0; k < 3; k++) {
			int nr = r + drChk[k];
			int nc = c + dcChk[k];
			if (map[nr][nc] == 1)
				cnt++;
		}
		if (cnt == 3)
			return true;
		else
			return false;
	}

	private static void dragonCurve(int r, int c, int generation, int cnt) {
		if (cnt == generation) {
			return;
		}
		newAdd = new ArrayList<Integer>();
		for (int i = list.size() - 1; i >= 0; i--) {
			int dir = list.get(i) + 1;
			if (dir == 4)
				dir = 0;
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			map[nr][nc] = 1;
			r = nr;
			c = nc;
			newAdd.add(dir);
		}
		move();
		dragonCurve(r, c, generation, cnt + 1);
	}

	private static void move() {
		for (int i = 0; i < newAdd.size(); i++) {
			list.add(newAdd.get(i));
		}

	}
}
