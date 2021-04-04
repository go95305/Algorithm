package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class commerce3 {
    static class Point {
        int next, weight;

        Point(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "next=" + next +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int passenger[] = {1,1,2,3,4};
        int[][] train = {{1, 2}, {1, 3}, {1, 4},{1,5}};
        List<Point> list[] = new ArrayList[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < train.length; i++) {
            int from = train[i][0] - 1;
            int to = train[i][1] - 1;
            list[from].add(new Point(to, passenger[from]));
            list[to].add(new Point(from, passenger[to]));
        }
        int ans = 0;
        int endPoint = 0;
        boolean v[] = new boolean[n];
        que.add(new Point(0, passenger[0]));
        v[0] = true;

        while (!que.isEmpty()) {
            Point p = que.poll();
//            System.out.println(p.next+1+":"+p.weight);
            if (ans <= p.weight) {
                ans = p.weight;
                if (endPoint < p.next)
                    endPoint = p.next;
            }
            int size = list[p.next].size();
            for (int i = 0; i < size; i++) {
                int next = list[p.next].get(i).next;
                if (!v[next]) {

                    v[next] = true;
                    que.add(new Point(next, p.weight + passenger[next]));
                }
            }
        }
        System.out.println(endPoint + 1 + " " + ans);

    }

}
