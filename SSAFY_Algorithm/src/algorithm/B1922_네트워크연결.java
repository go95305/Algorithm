package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1922_네트워크연결 {
    static int N, M;
    static int parent[];
    static List<Node> list;

    static class Node implements Comparable<Node> {
        int from, to, weight;

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N];
        make();
        list = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Node(from, to, weight));
        }

        Collections.sort(list);

        int cnt = 0;
        int sum = 0;
        for (Node node : list) {
            if (find(node.from) != find(node.to)) {
                sum += node.weight;
                cnt++;
                union(node.from, node.to);
                if (cnt == N - 1)
                    break;
            }
        }
        System.out.println(sum);
    }


    private static void make() {
        for (int i = 0; i < N; i++)
            parent[i] = i;
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX >= rootY)
            parent[rootX] = rootY;
        else
            parent[rootY] = rootX;
    }
}
