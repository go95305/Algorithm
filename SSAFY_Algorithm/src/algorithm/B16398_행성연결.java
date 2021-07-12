package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B16398_행성연결 {
    static int[] parent;
    static int N;
    static int map[][];
    static List<Point> list;

    static class Point implements Comparable<Point> {
        int from, to, weight;

        Point(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if (i == j) continue;
                list.add(new Point(i, j, weight));
            }
        }
        Collections.sort(list);

        int cnt = 0;
        long len = 0;
        for (int i = 0; i < list.size(); i++) {
            if (find(list.get(i).from) != find(list.get(i).to)) {
                union(list.get(i).from, list.get(i).to);
                len += list.get(i).weight;
                cnt++;
                if (cnt == N - 1)
                    break;
            }
        }

        System.out.println(len);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        if (rootX < rootY)
            parent[rootY] = rootX;
        else
            parent[rootX] = rootY;
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
}
