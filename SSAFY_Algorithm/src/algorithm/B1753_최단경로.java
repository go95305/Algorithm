package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

/** 정점이 많으면 인접 리스트를 사용해야 한다. */
public class B1753_최단경로 {
	static class Vertex implements Comparable<Vertex> {
		int no;
		int totalDistance; // totalDistance: 출발지에서 자신까지 오는 최단거리

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
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());// 정점 수
		E = Integer.parseInt(st.nextToken());// 간선 수
		st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;// 시작 정점
		ArrayList<Vertex> adj[] = new ArrayList[V];
		boolean visited[] = new boolean[V];
		int distance[] = new int[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Vertex>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int length = Integer.parseInt(st.nextToken());
			adj[from].add(new Vertex(to, length));
		}

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;// 시작정점에서 시작정점까지의 거리는 0

		int min = 0, current = 0;
		for (int i = 0; i < V; i++) {

			min = Integer.MAX_VALUE;
			// 1단계 : 방문하지 않은 정점들 중 출발지에서 자신까지 오는 비용이 최단인 정점을 고.려.할 경유지로 선택
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			// 2단계: 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 update

			/** 이부분이제일 중요(인접배열과의 차이점 */
			for (int j = 0; j < adj[current].size(); j++) {// 인접 배열과는 다르게 전체를 도는것이 아니라 연결된 정점 만큼만 돈다.
				// min: distance[current]와 같다.
				if (!visited[adj[current].get(j).no]
						&& distance[adj[current].get(j).no] > min + adj[current].get(j).totalDistance) {// 연결된 정점이 방문되지
																										// 않았고 연결된 정점의
																										// 가중치가(기존)
																										// 새로연결된 간선의
																										// 가중치의합보다 크면
					distance[adj[current].get(j).no] = min + adj[current].get(j).totalDistance;// update해준다.
				}
			}

			/** */
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
