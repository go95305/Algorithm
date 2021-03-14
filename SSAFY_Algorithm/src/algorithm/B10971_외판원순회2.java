package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B10971_외판원순회2 {
    static class Point {
        int to, weight;

        Point(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int ans;
    static int N;
    static boolean v[];
    static List<Point> list[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        list = new ArrayList[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        //list배열에  값 넣기
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < N; j++) {
                int weight = sc.nextInt();
                list[i].add(new Point(j, weight));
            }
        }
        ans = Integer.MAX_VALUE;
        v = new boolean[N];
        for (int i = 0; i < N; i++) {
            v[i] = true;
            dfs(i, i, 0, 0);
            v[i] = false;
        }
        System.out.println(ans);


    }

    private static void dfs(int startnode, int node, int count, int weight) {
        if (count == N - 1) {
            if (list[node].get(startnode).weight != 0) {
                int finaldist = weight + list[node].get(startnode).weight;
                ans = Math.min(ans, finaldist);
            }
            return;
        }
        int size = list[node].size();
        for (int i = 0; i < size; i++) {
            Point p = list[node].get(i);
            if (!v[p.to] && p.weight != 0) {
                v[p.to] = true;
                dfs(startnode, p.to, count + 1, p.weight + weight);
                v[p.to] = false;
            }

        }
    }
}
