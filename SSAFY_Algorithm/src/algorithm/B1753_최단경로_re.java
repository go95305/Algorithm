package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B1753_최단경로_re {
    static int V, E;

    static class Node implements Comparable<Node> {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        List<Node>[] list = new ArrayList[V];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        int start = Integer.parseInt(br.readLine())-1;
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
        }

        boolean visit[] = new boolean[V];
        dist[start] = 0;
        int min = 0;
        int current = 0;
        for (int i = 0; i < V; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < V; j++) {
                if (!visit[j] && min > dist[j]) {
                    min = dist[j];
                    current = j;
                }
            }
            visit[current] = true;

            for (int j = 0; j < list[current].size(); j++) {
                if (!visit[list[current].get(j).to] && dist[list[current].get(j).to] > min + list[current].get(j).weight)
                    dist[list[current].get(j).to] = min + list[current].get(j).weight;
            }
        }

        for (int i=0;i<V;i++){
            if (dist[i]==Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }
}
