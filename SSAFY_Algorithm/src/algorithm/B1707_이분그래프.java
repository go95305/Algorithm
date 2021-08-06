package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1707_이분그래프 {
    static int V, E;
    static List<Integer>[] list;
    static int[] team;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < K; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            list = new ArrayList[V];
            team = new int[V];
            flag = false;
            for (int i = 0; i < V; i++)
                list[i] = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                list[from].add(to);
                list[to].add(from);
            }

            for (int i = 0; i < V; i++) {
                if (flag)
                    break;
                if (team[i] == 0)
                    bfs(i);
            }
            System.out.println(flag ? "NO" : "YES");
        }
    }

    private static void bfs(int node) {
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        team[node] = -1;
        while (!que.isEmpty()) {
            Integer n = que.poll();
            int size = list[n].size();
            for (int i = 0; i < size; i++) {
                int num = list[n].get(i);
                if (team[num] == 0) {
                    que.add(num);
                    team[num] = team[n] * -1;
                } else if (team[n] + team[num] != 0) {
                    flag = true;
                    return;
                }
            }
        }
    }
}
