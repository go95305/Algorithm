package algorithm;

import java.util.Scanner;
import java.util.Arrays;

public class B1197_최소스패닝트리_크루스칼 {
	static span[] sl;
	static int[] parents;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();
		parents = new int[V];
		sl = new span[E];

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			int weight = sc.nextInt();
			sl[i] = new span(from, to, weight);
		}

		Arrays.sort(sl);
		make();
		long result = 0;
		long cnt = 0;
		for (int i = 0; i < sl.length; i++) {
			if (union(sl[i].from, sl[i].to)) {
				cnt++;
				result += sl[i].weight;
				if (cnt == V - 1)
					break;
			}
		}
		System.out.println(result);

	}

	private static void make() {
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}

	private static int find(int x) {

		if (parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);

	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	static class span implements Comparable<span> {
		int from;
		int to;
		int weight;

		public span(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(span o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

	}
}