package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class B17471_게리맨더링 {
	static int N;
	static int[] ar;
	static ArrayList<Integer>[] adj;
	static boolean v[];
	static int sum;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adj = new ArrayList[N + 1];
		for (int i = 1; i < adj.length; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		v = new boolean[N + 1];
		ar = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			ar[i] = sc.nextInt();
		}
		sum = 0;
		max = Integer.MAX_VALUE;
		for (int i = 1; i < N + 1; i++) {
			int num = sc.nextInt();
			for (int j = 0; j < num; j++) {
				adj[i].add(sc.nextInt());
			}
		}
			dfs(1);
//		System.out.println(max);
//		print(adj);

	}

	private static void dfs(int idx) {
		v[idx] = true;
		System.out.print(idx+" ");
		sum += ar[idx];
		int size = adj[idx].size();
		for (int i = 0; i < size; i++) {
			Integer n = adj[idx].get(i);
			if (!v[n]) {
				dfs(n);
			} 
//			else {
//				if (adj[idx].size() <= 2) {
//					int tmp = 0;
//					for (int j = 0; j < v.length; j++) {
//						if (!v[j]) {
//							tmp += ar[j];
//						}
//					}
//					if (max > Math.abs(sum - tmp)) {
//						max = sum;
//					}
//				}
//			}
		}

	}

	private static void print(ArrayList<Integer>[] adj) {
		for (int i = 0; i < adj.length; i++) {
			int size = adj[i].size();
			for (int j = 0; j < size; j++) {
				System.out.print(adj[i].get(j) + " ");
			}
			System.out.println();
		}
	}
}
