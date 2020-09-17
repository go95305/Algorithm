package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B1719_택배 {
	static class Point {
		int e, c;

		Point(int e, int c) {
			this.e = e;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Point> adj[] = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Point>();
		}
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt() - 1;
			int end = sc.nextInt() - 1;
			int cost = sc.nextInt();
			adj[start].add(new Point(end, cost));
			adj[end].add(new Point(start, cost));
		}

		for (int k = 0; k < N; k++) {
			int dist[] = new int[N];
			int sel[] = new int[N];
			boolean visited[] = new boolean[N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[k] = k;
			sel[k] = k;
			int min = 0;
			int current = 0;
			for (int i = 0; i < N; i++) {
				min = Integer.MAX_VALUE;
				for (int j = 0; j < N; j++) {
					if (!visited[j] && min > dist[j]) {
						min = dist[j];
						current = j;
					}
				}
				visited[current] = true;

				for (int j = 0; j < adj[current].size(); j++) {
					if (!visited[adj[current].get(j).e] && dist[adj[current].get(j).e] > min + adj[current].get(j).c) {
						dist[adj[current].get(j).e] = min + adj[current].get(j).c;
						sel[adj[current].get(j).e] = current;

					}
				}

			}
//			System.out.println(Arrays.toString(sel));
			trace(k, sel, N);
		}

	}

	private static void trace(int k, int[] sel, int N) {
		StringBuilder sb = new StringBuilder();
		int i, j, v = 0;
		for (i = 0; i < N; i++) {
			if (i == k) {
				sb.append("- ");
				continue;
			}
			for (v = i + 1, j = sel[i]; j != k; j = sel[j])
				v = j + 1;
			sb.append(v + " ");
		}
		System.out.println(sb);
	}
}
