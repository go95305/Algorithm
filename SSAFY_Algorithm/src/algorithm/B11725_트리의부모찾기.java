package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11725_트리의부모찾기 {
    static boolean v[];
    static ArrayList<Integer> list[];
    static Queue<Integer> que;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans[] = new int[N + 2];
        StringTokenizer st;
        list = new ArrayList[N + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        ans = new int[N + 1];
        que = new LinkedList<>();
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        ans[1] = 1;
        que.add(1);
        while (!que.isEmpty()) {
            Integer n = que.poll();
            for (int i = 0; i < list[n].size(); i++) {
                int tmp = list[n].get(i);
                if (ans[tmp] == 0) {
                    que.add(tmp);
                    ans[tmp] = n;
                }

            }
        }
        for (int i = 2; i <ans.length ; i++) {
            System.out.println(ans[i]);
        }

    }


}
