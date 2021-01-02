package algorithm;

import java.util.*;

public class B2606_바이러스 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int conn = sc.nextInt();
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < conn; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            list[from].add(to);
            list[to].add(from);
        }



        int cnt = 0;
        boolean v[] = new boolean[N + 1];
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        v[1] = true;
        while (!que.isEmpty()) {
            Integer p = que.poll();
            int size = list[p].size();
            for (int i = 0; i < size; i++) {
                if (!v[list[p].get(i)]) {
                    v[list[p].get(i)] = true;
                    que.add(list[p].get(i));
                    cnt++;
                }

            }
        }
        System.out.println(cnt);
    }
}
