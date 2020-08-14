package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class S1251_하나로 {
	static int N;
	static double E;
	static int[][] X;
	static int parent[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			X = new int[2][N];
			parent = new int[N];
			ArrayList<Point> island = new ArrayList<Point>();// 처음 각 섬의 좌표를 저장하는 Point객체
			ArrayList<Edge> edge = new ArrayList<Edge>();
			for (int i = 0; i < N; i++) {
				X[0][i] = sc.nextInt();// X배열에 좌표값들을 저장
			}

			for (int i = 0; i < N; i++) {
				X[1][i] = sc.nextInt();// X배열에 좌표값들을 저장
			}
			E = sc.nextDouble();

			for (int j = 0; j < N; j++) {
				island.add(new Point(X[0][j], X[1][j]));// 각섬의 좌표를 가지고 객체를 생성
				parent[j] = j;// 섬 객체가 생성될대마다 스스로를 가리키는 parent 배열 초기화
			}

			for (int i = 0; i < island.size(); i++) {
				Point p = island.get(i);
				for (int j = 0; j < island.size(); j++) {
					if (i != j) {
						double tmp = (Math.pow(Math.abs(p.r - island.get(j).r), 2)// 가중치를 구한다.
								+ Math.pow(Math.abs(p.c - island.get(j).c), 2)) * E;
						edge.add(new Edge(parent[i], parent[j], tmp));// Edge클래스에 가중치와 각 섬이 가리키는 다른 섬의 정보를 입력하여 객체 생성
					}
				}
			}
			Collections.sort(edge);// 가중치를 오름차순기준으로 정렬

			double sum = 0;//값이 크므로 double로 설정
			int cnt = 0;
			for (int i = 0; i < edge.size(); i++) {
				if (find(edge.get(i).from) != find(edge.get(i).to)) {
					sum += edge.get(i).weight;
					cnt++;
					union(edge.get(i).from, edge.get(i).to);
					if (cnt == N - 1) {
						break;
					}
				}
			}
			System.out.printf("#%d %.0f\n", test_case, sum);
		}
	}

	private static void union(int x, int y) {
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
		double weight;

		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

	}

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
