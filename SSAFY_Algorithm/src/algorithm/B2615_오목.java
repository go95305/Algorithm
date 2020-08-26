package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2615_오목 {
	static int map[][];
	static int[] dr = { -1, 0, 1, 1 };
	static int[] dc = { 1, 1, 1, 0 };
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[19][19];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		flag = false;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1 || map[i][j] == 2) {
					search(i, j, 1, map[i][j]);
				}
			}
		}
		if (!flag) {
			System.out.println(0);
		}
	}

	private static void search(int x, int y, int cnt, int blackwhite) {
		for (int k = 0; k < 4; k++) {
			cnt = 1;
			int nr = x + dr[k];
			int nc = y + dc[k];
			while (nr >= 0 && nr < 19 && nc >= 0 && nc < 19) {
				if (map[nr][nc] == blackwhite) {
					cnt++;
				} else {
					break;
				}
				nr += dr[k];
				nc += dc[k];
			}
			if (cnt == 5) {
				int bCnt = 1;
				nr = nr + (dr[k] * -1);
				nc = nc + (dc[k] * -1);
				while (nr >= 0 && nr < 19 && nc >= 0 && nc < 19) {
					if (map[nr][nc] == blackwhite) {
						bCnt++;
					} else {
						break;
					}
					nr += (dr[k] * -1);
					nc += (dc[k] * -1);
				}
				if (bCnt > 6) {
					continue;
				}
				flag = true;
				System.out.println(blackwhite);
				System.out.println(x + 1 + " " + (y+1));

			}
		}
	}
}
