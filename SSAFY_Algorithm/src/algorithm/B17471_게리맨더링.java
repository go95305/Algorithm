package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class B17471_게리맨더링 {
	static int N;
	static int[] population;
	static ArrayList<Integer>[] adj;
	static boolean v[];
	static int sum;
	static int max;
	static int Ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adj = new ArrayList[N + 1];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		v = new boolean[N + 1];
		population = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			population[i] = sc.nextInt();
		}
		sum = 0;
		for (int i = 1; i < N + 1; i++) {
			int num = sc.nextInt();
			for (int j = 0; j < num; j++) {
				int to = sc.nextInt();
				adj[i].add(to);
				adj[to].add(i);
			}
		}
//		print();
		Ans=Integer.MAX_VALUE;
		powerSet(1, 0);
		System.out.println(Ans);
	}

	private static void powerSet(int idx, int k) {
		if (idx == adj.length) {
			int cnt = 0;
			max=0;
			boolean chk[] = new boolean[N + 1];
			if (k > 0) {
				for (int i = 1; i < adj.length; i++) {
					if (chk[i]) {
						dfs(i, chk);
						cnt++;
					} else {
						dfs2(i, chk);
						cnt++;
					}
				}
				if (cnt == 2) {
					Ans=Math.min(max, Ans);
				}
			}
			return;
		}

		v[idx] = true;
		powerSet(idx + 1, k + 1);
		v[idx] = false;
		powerSet(idx + 1, k);
	}

	private static void dfs2(int idx, boolean[] chk) {
		chk[idx] = true;
		max-=population[idx];
		int size = adj[idx].size();
		for (int i = 0; i < size; i++) {
			Integer n = adj[idx].get(i);
			if (!v[n]&&!chk[n]) {
				dfs2(n, chk);
			}
		}

	}

	private static void dfs(int idx, boolean chk[]) {
		chk[idx] = true;
		max+=population[idx];
		int size = adj[idx].size();
		for (int i = 0; i < size; i++) {
			Integer n = adj[idx].get(i);
			if (v[n] &&!chk[n]) {
				dfs(n, chk);
			}
		}
	}

	private static void print() {
		for (int i = 0; i < adj.length; i++) {
			int size = adj[i].size();
			for (int j = 0; j < size; j++) {
				System.out.print(adj[i].get(j) + " ");
			}
			System.out.println();
		}
	}

}
