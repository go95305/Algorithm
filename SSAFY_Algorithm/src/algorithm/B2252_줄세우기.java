package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2252_줄세우기 {
    static int N, M;
    static int map[];
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++)
            list[i] = new ArrayList<>();
        map = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            list[from].add(to);
            map[to]++;
        }

        Queue<Integer> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                ans.add(i);
                que.add(i);
            }
        }
        while (!que.isEmpty()) {
            Integer num = que.poll();
            for (int i = 0; i < list[num].size(); i++) {
                int n = list[num].get(i);
                map[n]--;
                if (map[n] == 0) {
                    que.add(n);
                    ans.add(n);
                }
            }
        }

        for (int i=0;i<ans.size();i++)
            System.out.print(ans.get(i)+1+" ");


    }
}
