package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class S1247_최적경로 {
	static int N;
	static Point home;
	static Point work;
	static ArrayList<Point> client;
	static boolean v[];
	static int Ans;

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			v = new boolean[N];
			work = new Point(sc.nextInt(), sc.nextInt());
			client = new ArrayList<Point>();
			home = new Point(sc.nextInt(), sc.nextInt());
			for (int i = 0; i < N; i++) {
				client.add(new Point(sc.nextInt(), sc.nextInt()));
			}
			Ans = Integer.MAX_VALUE;

			permutation(work.r, work.c, 0, 0);
			System.out.printf("#%d %d\n",test_case,Ans);
		}
	}

	private static void permutation(int r, int c, int sum, int k) {
		if (k == N) {
			sum += Math.abs(r - home.r) + Math.abs(c - home.c);
//			System.out.println(sum);
			if (Ans > sum) {
				Ans = sum;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				permutation(client.get(i).r, client.get(i).c,
						sum + (Math.abs(r - client.get(i).r) + Math.abs(c - client.get(i).c)), k + 1);
				v[i] = false;
			}
		}
	}
}
