package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.GenericArrayType;
import java.util.*;

public class B15971_두로봇 {
    static int N;
    static List<Node>[] list;
    static boolean v[];
    static int ans;
    static boolean flag;

    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
            list[to].add(new Node(from, weight));
        }
        v = new boolean[N];
        ans = Integer.MAX_VALUE;
        flag = false;
        v[start] = true;
        dfs(start, end, 0, 0);
        System.out.println(ans);

    }

    private static void dfs(int start, int end, int longest, int sum) {
        if (start == end) {
            ans = Math.min(ans, sum - longest);
            return;
        }

        int size = list[start].size();
        for (int i = 0; i < size; i++) {
            int n = list[start].get(i).to;
            if (!v[n]) {
                v[n] = true;
                dfs(n, end, Math.max(longest, list[start].get(i).weight), sum + list[start].get(i).weight);
            }
        }
    }
}
