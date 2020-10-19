package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class S10888_음식배달 {
	static int map[][];
	static ArrayList<Point> home;
	static ArrayList<Point> food;
	static boolean v[];
	static int max;
	static int sel[];

	static class Point {
		int r, c, w;

		Point(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			home = new ArrayList<Point>();
			food = new ArrayList<Point>();
			map = new int[N][N];
			sel = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1)
						home.add(new Point(i, j, 1));
					else if (map[i][j] > 1)
						food.add(new Point(i, j, map[i][j]));
				}
			}
			max = 0;
			v = new boolean[food.size()];
			combination(0, 0);
		}
	}

	private static void combination(int idx, int k) {
		if (k == food.size()) {
			System.out.println(Arrays.toString(sel));
		}

		for (int i = idx; i < food.size(); i++) {
			sel[i] = i;
			combination(i + 1, k + 1);
		}
	}

}
