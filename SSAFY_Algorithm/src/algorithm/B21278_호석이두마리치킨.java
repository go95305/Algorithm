package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B21278_호석이두마리치킨 {
    static int N, M;
    static List<Integer>[] list;
    static int sel[];
    static int ans;
    static int[] answer;

    static class Point {
        int num, dist;

        Point(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        sel = new int[2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            list[from].add(to);
            list[to].add(from);
        }
        answer = new int[2];
        ans = Integer.MAX_VALUE;
        combination(0, 0);
        for (int i = 0; i < 2; i++)
            System.out.print(answer[i] + 1+" ");
        System.out.println(ans*2);


    }

    private static void combination(int idx, int k) {
        if (k == sel.length) {
            getDistance();
            return;
        }

        for (int i = idx; i < N; i++) {
            sel[k] = i;
            combination(i + 1, k + 1);
        }
    }

    private static void getDistance() {
        boolean[] v = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < sel.length; i++) {
            dist[sel[i]] = 0;
            v[sel[i]] = true;
        }
        for (int i = 0; i < sel.length; i++) {
            boolean[] copy = v.clone();
            bfs(sel[i], dist, copy);
        }

        /** dist의 합을 구해서 최소면 왕복시간의 최소이므로 답을 갱신한다. */
        int sum = 0;
        for (int i = 0; i < dist.length; i++)
            sum += dist[i];

        if (sum < ans) {
            ans = sum;
            answer[0] = sel[0];
            answer[1] = sel[1];
        } else if (sum == ans) {
            answer[0] = Math.min(answer[0], sel[0]);
            answer[1] = Math.min(answer[1], sel[1]);
        }
    }

    private static void bfs(int value, int[] dist, boolean[] v) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(value, 1));
        while (!que.isEmpty()) {
            Point p = que.poll();
            int size = list[p.num].size();
            for (int i = 0; i < size; i++) {
                int num = list[p.num].get(i);
                if (!v[num]) {
                    dist[num] = Math.min(p.dist, dist[num]);
                    v[num] = true;
                    que.add(new Point(num, p.dist + 1));
                }
            }
        }
    }
}
