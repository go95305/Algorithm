package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16947_서울지하철2호선 {
    static int N;
    static int map[];
    static boolean v[];
    static boolean cycle[];
    static boolean flag;
    static List<Integer> list[];
    static int ans[];

    static class Point {
        int node, cnt;

        Point(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++)
            list[i] = new ArrayList<>();
        cycle = new boolean[N];
        ans = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            list[from].add(to);
            list[to].add(from);
        }

        /** 루프나올때까지 DFS */
        findLoop();
        dist();
        for (int i=0;i<N;i++)
            System.out.print(ans[i]+" ");
    }

    private static void dist() {
        for (int i = 0; i < N; i++) {
            if (!cycle[i]) {
                v = new boolean[N];
                bfs(i);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(node, 1));
        v[node] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();
            int size = list[p.node].size();
            for (int i = 0; i < size; i++) {
                int num = list[p.node].get(i);
                if (!v[num]) {
                    if (cycle[num]) {
                        ans[node] = p.cnt;
                        return;
                    } else {
                        v[num] = true;
                        que.add(new Point(num, p.cnt + 1));
                    }
                }
            }
        }

    }

    private static void findLoop() {
        for (int i = 0; i < N; i++) {
            v = new boolean[N];
            flag = false;
            v[i] = true;
            dfs(i, i, 0);
            if (flag)
                cycle[i] = true;
        }
    }

    private static void dfs(int node, int start, int cnt) {
        if (node == start && cnt >= 2) {
            flag = true;
            return;
        }

        v[node] = true;
        int size = list[node].size();
        for (int i = 0; i < size; i++) {
            int num = list[node].get(i);
            if (!v[num]) {
                dfs(num, start, cnt + 1);
            } else {
                if (num == start && cnt >= 2) {
                    dfs(num, start, cnt);
                }
            }

            if (flag)
                return;
        }
    }

}
