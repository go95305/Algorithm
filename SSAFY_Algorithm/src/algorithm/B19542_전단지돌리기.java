package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B19542_전단지돌리기 {
    static List<Integer> list[];
    static boolean v[];

    static class Node {
        int value, depth;

        Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }

    static int depth[];
    static int N, S, D;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()) - 1;
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        depth = new int[N];
        Arrays.fill(depth, 1);
//        String n;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
//            String [] tmp = n.split(" ");
//            System.out.println(tmp[0]+" "+tmp[1]);
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            list[from].add(to);
        }

        v = new boolean[N];
        //각 노드별 최고 깊이
        for (int i = 0; i < N; i++) {
            Queue<Node> que = new LinkedList<>();
            que.add(new Node(i, 0));
            while (!que.isEmpty()) {
                Node n = que.poll();
                int size = list[n.value].size();
                if (size == 0) {
                    depth[i] = n.depth;
                }
                for (int k = 0; k < size; k++) {
                    que.add(new Node(list[n.value].get(k), n.depth + 1));
                }
            }
        }
        System.out.println(Arrays.toString(depth));

        ans = Integer.MAX_VALUE;
        v[S] = true;
        dfs(S, 0);
        System.out.println(ans * 2);
    }

    private static void dfs(int num, int cnt) {
        int size = list[num].size();
        for (int i = 0; i < size; i++) {
            int next = list[num].get(i);
            if (depth[next] >= D) {
                v[next] = true;
                dfs(next, cnt + 1);
                v[next] = false;
            } else {
                ans = Math.min(ans, cnt);
            }
        }
    }

}
