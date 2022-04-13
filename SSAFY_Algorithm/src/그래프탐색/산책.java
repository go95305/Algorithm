package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 산책 {
    static int N, M;
    static int go, ed;
    static int way;
    static boolean v[];
    static int rv[];
    static List<Integer>[] list;

    static class Point {
        int to, cnt, way;

        Point(int to, int cnt, int way) {
            this.to = to;
            this.cnt = cnt;
            this.way = way;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        rv = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(list[i]);
        }
        st = new StringTokenizer(br.readLine(), " ");
        go = Integer.parseInt(st.nextToken());
        ed = Integer.parseInt(st.nextToken());
        v = new boolean[N + 1];
        way = Integer.MAX_VALUE;

        int a = bfs(go, ed);

        v = new boolean[N + 1];
        int last = rv[ed];
//        System.out.println(Arrays.toString(rv));
        while (last > 0) {
            v[last] = true;
            last = rv[last];
        }

//        System.out.println(Arrays.toString(v));
        way = Integer.MAX_VALUE;
        int b = bfs(ed, go);
//        System.out.println(Arrays.toString(rv));
        System.out.println(a + b);


    }

    private static int bfs(int go, int ed) {
        int ans = 0;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(go, 0, go));
        v[go] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();

            int size = list[p.to].size();
            for (int i = 0; i < size; i++) {
                Integer n = list[p.to].get(i);
                if (!v[n]) {
                    v[n] = true;
                    rv[n] = p.to;
                    que.add(new Point(n, p.cnt + 1, (10 * p.way) + n));
                }
                if (n == ed) {
                    ans = p.cnt+1;
                    return ans;
                }
            }
        }
        return ans;
    }
}

