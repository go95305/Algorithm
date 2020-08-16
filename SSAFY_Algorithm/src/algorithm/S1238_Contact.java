package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1238_Contact {
	static ArrayList<Integer>[] adj;
	static ArrayList<Point> Ans;
	static boolean v[];
	static int lev;
	static ArrayList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			adj = new ArrayList[N];
			Ans = new ArrayList<Point>();
			lev = 0;
			int start = sc.nextInt();
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			v = new boolean[N];
			for (int i = 0; i < N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adj[from].add(to);
			}
			bfs(start, 0);
			list = new ArrayList<Integer>();
			for (int i = 0; i < Ans.size(); i++) {
				if (Ans.get(i).level == lev) {
					list.add(Ans.get(i).p);
				}
			}
			Collections.sort(list, Collections.reverseOrder());
			System.out.printf("#%d %d\n",test_case,list.get(0));
		}
	}

	private static void bfs(int start, int level) {
		Queue<Point> que = new LinkedList();
		v[start] = true;
		que.add(new Point(start, level));
		while (!que.isEmpty()) {
			Point p = que.poll();
			Ans.add(new Point(p.p, p.level));
			lev = p.level;
			int size = adj[p.p].size();
			for (int i = 0; i < size; i++) {
				Integer n = adj[p.p].get(i);
				if (!v[n]) {
					v[n] = true;
					que.add(new Point(n, p.level + 1));
				}
			}
		}

	}

	static class Point {
		int p;
		int level;

		Point(int p, int level) {
			this.p = p;
			this.level = level;
		}

	}

}
