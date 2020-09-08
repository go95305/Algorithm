package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class S1251_하나로_프림 {
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
			ArrayList<Point> island = new ArrayList<Point>();// 처음 각 섬의 좌표를 저장하는 Point객체
			ArrayList<Edge>[] edge = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				X[0][i] = sc.nextInt();// X배열에 X좌표값들을 저장
			}

			for (int i = 0; i < N; i++) {
				X[1][i] = sc.nextInt();// X배열에 Y좌표값들을 저장
			}
			for (int i = 0; i < edge.length; i++) {
				edge[i] = new ArrayList<Edge>();
			}
			E = sc.nextDouble();
			for (int j = 0; j < N; j++) {
				island.add(new Point(X[0][j], X[1][j]));// 각섬의 좌표를 가지고 객체를 생성후 리스트에 저장
			}

			for (int i = 0; i < island.size(); i++) {
				Point p = island.get(i);
				for (int j = 0; j < island.size(); j++) {
					if (i != j) {
						double tmp = (Math.pow(Math.abs(p.r - island.get(j).r), 2)// 가중치를 구한다.
								+ Math.pow(Math.abs(p.c - island.get(j).c), 2)) * E;
						edge[i].add(new Edge(j, tmp));// Edge클래스에 가중치와 각 섬이 가리키는 다른 섬의 정보를 입력하여 객체 생성
					}
				}
			}
			
			

			boolean[] v = new boolean[edge.length];
			double [] dist = new double[edge.length];
			Arrays.fill(dist, Double.MAX_VALUE); // 초기화
			// 0번 선택
			dist[0] = 0;

			for (int cnt = 0; cnt < edge.length - 1; cnt++) {
				int minIdx = -1;
				double minD = Double.MAX_VALUE;
				// 거리배열에서 값이 제일 작은 정점을 구한다
				for (int i = 0; i < edge.length; i++) {
					if (dist[i] < minD && !v[i]) {
						minD = dist[i];
						minIdx = i;
					}
				}

				v[minIdx] = true;

				for (int i = 0; i < edge[minIdx].size(); i++) {
					if (!v[edge[minIdx].get(i).to] && edge[minIdx].get(i).weight < dist[edge[minIdx].get(i).to]) {

						dist[edge[minIdx].get(i).to] = edge[minIdx].get(i).weight;

					}
				}
			}
			double res=0;
			for (int i = 0; i < dist.length; i++) {
				res+=dist[i];
			}
			
			System.out.printf("#%d %d\n",test_case,Math.round(res));
		}
	}

	static class Edge implements Comparable<Edge> {
		int to;
		double weight;

		public Edge(int to, double weight) {

			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight, o.weight);
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
