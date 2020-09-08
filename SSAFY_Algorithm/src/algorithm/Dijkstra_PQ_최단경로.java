package algorithm;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_PQ_최단경로 {
	static class Edge implements Comparable<Edge>{
		int v, weight;
		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		@Override
		public String toString() {
			return weight + "";
		}
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("최단경로.txt"));
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		//K
		int K = sc.nextInt()-1;
		///////////////////////////
		List<Edge>[] adj = new ArrayList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
		for(int i = 0; i < E; i++) {
			//첫번째가 출발지, 두번째가 도착지, 세번째가 가중치ㅋ
			adj[sc.nextInt()-1].add(new Edge(sc.nextInt()-1, sc.nextInt()));
		}
		//
		//dijkstra
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V];
		Edge[] D = new Edge[V];
		//0번에서 출발하는걸로.
		for(int i = 0; i < V; i++) {
			//원하는 출발지
			if( i == K ) {
				D[i] = new Edge(i, 0);
				check[i] = true;
			}
			else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(D[i]);
		}
		while( !pq.isEmpty() ) {
			Edge edge = pq.poll();
			if(edge.weight == Integer.MAX_VALUE)
				break;
			for( Edge next : adj[edge.v] ) {
				// check되지 않았으면서, D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
				if( !check[next.v] && D[next.v].weight > D[edge.v].weight + next.weight ) {
					D[next.v].weight = D[edge.v].weight + next.weight;
					//decrease key
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
			check[edge.v] = true;
		}
		
		for(int i = 0; i < V; i++) {
			if( D[i].weight == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(D[i]);
		}
	}
}












