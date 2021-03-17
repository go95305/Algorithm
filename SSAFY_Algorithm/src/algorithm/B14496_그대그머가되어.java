package algorithm;

import java.util.*;

public class B14496_그대그머가되어 {
    static class Point {
        int to, cnt;

        Point(int to, int cnt) {
            this.to = to;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = Integer.MAX_VALUE;
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Point> list[] = new ArrayList[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            list[from].add(new Point(to, 0));
            list[to].add(new Point(from, 0));
        }
        Queue<Point> que = null;
        que = new LinkedList<>();
        que.add(new Point(a, 0));
        boolean v[] = new boolean[N];
        v[a] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.to == b) {
                ans = Math.min(ans, p.cnt);
//                break;
            }
            int size = list[p.to].size();
            for (int j = 0; j < size; j++) {
                Integer n = list[p.to].get(j).to;
                if (!v[n]) {
                    v[n] = true;
                    que.add(new Point(n, p.cnt + 1));
                }
            }
        }
        if (ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
