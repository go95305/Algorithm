package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B12851_숨바꼭질2 {
    static class Point {
        int value, cnt;

        Point(int value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int shortest = Integer.MAX_VALUE;
        int cnt = 0;
        boolean v[] = new boolean[100001];
        v[N] = true;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(N, 0));
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Point p = que.poll();
                if (p.value == K) {
                    shortest = p.cnt;
                    cnt++;
                }
                int plus = p.value + 1;
                int minus = p.value - 1;
                int times = p.value * 2;
                if (times <= 100000 && !v[times]) {
                    que.add(new Point(times, p.cnt + 1));
                    list.add(times);
                }
                if (plus <= 100000 && !v[plus]) {
                    que.add(new Point(plus, p.cnt + 1));
                    list.add(plus);
                }
                if (minus >= 0 && !v[minus]) {
                    que.add(new Point(minus, p.cnt + 1));
                    list.add(minus);
                }
            }
            if (cnt > 0)
                break;
            //큐를 한큐 돌고 나서 방문체크
            for (int i = 0; i < list.size(); i++) {
                int num = list.get(i);
                v[num] = true;
            }
        }
        System.out.println(shortest);
        System.out.println(cnt);

    }
}
