package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class S5643_키순서 {
	static int N, M;
	static ArrayList<Integer>[] list;
	static int frontSum;
	static int backSum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			list = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < M; i++) {
				int from = sc.nextInt() - 1;
				int to = sc.nextInt() - 1;
				list[from].add(to);
			}
			int ans = 0;

			for (int i = 0; i < N; i++) {
				frontSum = 0;
				backSum = 0;
				dfs_before(0, 0);
				dfs_after(i, 0);
				if (N - (frontSum + backSum) == 1)
					ans++;
			}
		}
	}

	private static void dfs_after(int idx, int cnt) {
		if (list[idx].size() == 0) {
			frontSum += cnt;
			return;
		}

		for (int i = 0; i < list[idx].size(); i++) {
			Integer n = list[idx].get(i);
			dfs_after(n, cnt + 1);
		}
	}

	private static void dfs_before(int idx, int cnt) {
//		if
	}
}
