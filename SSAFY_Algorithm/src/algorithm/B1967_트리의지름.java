package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1967_트리의지름 {
    static int N;
    static List<Point> list[];
    static boolean v[];
    static int max;
    static int maxIdx;

    static class Point {
        int to, weight;

        Point(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for (int i = 0; i < list.length; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Point(to, weight));
            list[to].add(new Point(from, weight));
        }
        max = 0;
        maxIdx = 0;
        v = new boolean[N];
        v[0] = true;
        dfs(0, 0);

        max = 0;
        v = new boolean[N];
        v[maxIdx] = true;
        dfs(maxIdx, 0);
        System.out.println(max);

    }

    private static void dfs(int node, int cnt) {
        if (max < cnt) {
            max = cnt;
            maxIdx = node;
        }

        int size = list[node].size();
        for (int i = 0; i < size; i++) {
            int num = list[node].get(i).to;
            if (!v[num]) {
                v[num] = true;
                dfs(num, cnt + list[node].get(i).weight);
            }
        }
    }
}
