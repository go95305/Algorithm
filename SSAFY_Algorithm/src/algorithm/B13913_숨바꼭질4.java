package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B13913_숨바꼭질4 {
    static class Point {
        int num, cnt;

        Point(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        boolean v[] = new boolean[100001];
        int parent[] = new int[100001];
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(N, 0));
        v[N] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.num == K) {
                System.out.println(p.cnt);
                List<Integer> list = new ArrayList<>();
                list.add(K);
                while (K != N) {
                    list.add(parent[K]);
                    K = parent[K];
                }

                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i) + " ");
                }
            }


            if (p.num * 2 > 0 && p.num * 2 < 100001 && !v[p.num * 2]) {
                v[p.num * 2] = true;
                parent[p.num * 2] = p.num;
                que.add(new Point(p.num * 2, p.cnt + 1));

            }
            if (p.num + 1 < 100001 && !v[p.num + 1]) {
                v[p.num + 1] = true;
                parent[p.num + 1] = p.num;
                que.add(new Point(p.num + 1, p.cnt + 1));
            }
            if (p.num - 1 >= 0 && !v[p.num - 1]) {
                v[p.num - 1] = true;
                parent[p.num - 1] = p.num;
                que.add(new Point(p.num - 1, p.cnt + 1));
            }
        }
    }
}
