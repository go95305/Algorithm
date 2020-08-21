package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B4386_별자리만들기 {
	static int N;
	static ArrayList<Point> list;
	static ArrayList<Edge> edge;
	static int parent[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		parent = new int[N];
		list = new ArrayList<Point>();
		edge = new ArrayList<Edge>();

		for (int i = 0; i < N; i++) {
			list.add(new Point(sc.nextDouble(), sc.nextDouble()));
			parent[i] = i;
		}

		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					double tmp = Math.sqrt(Math.pow(p.x - list.get(j).x, 2) + Math.pow(p.y - list.get(j).y, 2));
					edge.add(new Edge(parent[i], parent[j], tmp));
				}
			}
		}
		Collections.sort(edge);

		int cnt = 0;
		double sum = 0;
		for (int i = 0; i < edge.size(); i++) {
			if (find(edge.get(i).from) != find(edge.get(i).to)) {
				sum += edge.get(i).dist;
				cnt++;
				Union(edge.get(i).from, edge.get(i).to);
				if (cnt == N - 1) {
					break;
				}
			}
		}
		System.out.printf("%.2f", sum);// 소숫점 2자리 까지만 출력

	}

	private static void Union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px >= py) {
			parent[px] = py;
		} else {
			parent[py] = px;
		}
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double dist;

		Edge(int from, int to, double dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.dist, o.dist);
		}

	}

	static class Point {
		double x;
		double y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
}
