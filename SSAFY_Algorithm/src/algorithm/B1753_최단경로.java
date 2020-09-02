package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1753_최단경로 {
	static class Vertex implements Comparable<Vertex> {
		int no, totalDistance; // totalDistance: 출발지에서 자신까지 오는 최단거리

		public Vertex(int no, int totalDistance) {
			super();
			this.no = no;
			this.totalDistance = totalDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.totalDistance, o.totalDistance); // totalDistance가 작은 비용이 우선적으로 처리
		}

	}

	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		V = Integer.parseInt(st.nextToken());// 정점 수
		E = Integer.parseInt(st.nextToken());// 간선 수
		st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;// 시작 정점
		int matrix[][] = new int[V][V];
		boolean visited[] = new boolean[V];
		int distance[] = new int[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int length = Integer.parseInt(st.nextToken());
			matrix[from][to] = length;
		}
		
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pQueue.offer(new Vertex(start, distance[start]));
		Vertex current = null;
		while (!pQueue.isEmpty()) {

			// 1단계 : 방문하지 않은 정점들 중 출발지에서 자신까지 오는 비용이 최단인 정점을 고.려.할 경유지로 선택
			current = pQueue.poll();
			if (visited[current.no])
				continue; // PQ에 남아있던 totalDistance의 최소비용보다 더 큰 상태(이전에 같은 노드에서 이미 최소값을 구했으므로 사용필요가 없다)
			visited[current.no] = true;
			// 2단계: 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 update
			for (int j = 0; j < V; j++) {
				if (!visited[j] && matrix[current.no][j] != 0
						&& distance[j] > current.totalDistance + matrix[current.no][j]) {
					distance[j] = current.totalDistance + matrix[current.no][j];
					pQueue.offer(new Vertex(j, distance[j]));
				}
			}
		}
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] != Integer.MAX_VALUE) {
				System.out.println(distance[i]);
			} else {
				System.out.println("INF");
			}
		}
	}
}
