package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11725_트리의부모찾기_re {
    static int N;
    static List<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }

        int ans[] = new int[N + 1];
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        while (!que.isEmpty()) {
            Integer n = que.poll();
            int size = list[n].size();
            for (int k = 0; k < size; k++) {
                if (ans[list[n].get(k)] == 0) {
                    ans[list[n].get(k)] = n;
                    que.add(list[n].get(k));
                }
            }
        }
        for (int i=2;i<N+1;i++){
            System.out.println(ans[i]);
        }
    }
}
