package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class S1238_Contact {
	static ArrayList<Integer>[] adj;
	static boolean v[];
	static ArrayList<int[]> rank;
	static int Ans;
	static int max;
	static boolean value[];
	static Integer dest;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			adj = new ArrayList[101];
			Ans = 0;
			rank = new ArrayList<int[]>();
			int N = sc.nextInt();
			int start = sc.nextInt();
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			v = new boolean[101];
			value = new boolean[101];
			for (int i = 0; i < N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adj[from].add(to);
			}
			dfs(start, 0);
			max = 0;
			for (int i = 0; i < rank.size(); i++) {
				System.out.println(rank.get(i)[0] + " " + rank.get(i)[1]);
			}
//			System.out.println();
			for (int i = 0; i < rank.size(); i++) {
				if (rank.get(i)[1] > max) {
					max = rank.get(i)[1];
					Ans = rank.get(i)[0];
				}
			}
//			System.out.println(Ans);

		}

	}

	private static void dfs(int start, int level) {
		v[start] = true;
		int size = adj[start].size();

		boolean flag = false;
		for (int i = 0; i < size; i++) {
			dest = adj[start].get(i);
			if (!v[dest]) {
				flag = true;
				dfs(dest, level + 1);
				v[dest] = false;
			}
		}

		if (!flag) {
			if (!value[dest]) {
				value[dest] = true;
				rank.add(new int[] { start, level });
			}
		}
	}

}
