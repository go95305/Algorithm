package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class S5643_키순서 {
	static int N, M;
	static ArrayList<Integer>[] list, list2;
	static int frontSum;
	static boolean v[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			list = new ArrayList[N];
			list2 = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<Integer>();
				list2[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < M; i++) {
				int from = sc.nextInt() - 1;
				int to = sc.nextInt() - 1;
				list[from].add(to);
				list2[to].add(from);
			}
			int ans = 0;

			for (int i = 0; i < N; i++) {
				v = new boolean[N];
				frontSum = 0;
				dfs_after(list, i, 0, i);
				v = new boolean[N];
				dfs_after(list2, i, 0, i);
				if (frontSum == N - 1)
					ans++;
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	private static void dfs_after(ArrayList<Integer>[] lst, int idx, int cnt, int start) {
		if (idx != start)
			frontSum++;
		v[idx] = true;
		for (int i = 0; i < lst[idx].size(); i++) {
			Integer n = lst[idx].get(i);
			if (!v[n])
				dfs_after(lst, n, cnt + 1, start);
		}
	}

}
