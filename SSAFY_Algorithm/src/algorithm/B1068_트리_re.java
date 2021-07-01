package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1068_트리_re {
    static boolean v[];
    static List<Integer>[] list;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int map[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int root = 0;
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            if (map[i] == -1)
                root = i;
        }
        list = new ArrayList[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            if (map[i] != -1) {
                list[map[i]].add(i);
            }
        }
        v = new boolean[N];

        int del = Integer.parseInt(br.readLine());
        ans = 0;
        v[del] = true;

        if (!v[root])
            leafNode(root);//root노드부터  탐색해서 리프노드 찾기

        System.out.println(ans);

    }

    private static void leafNode(int root) {
        int size = list[root].size();
        if (size == 0) {
            ans++;
            return;
        }

        for (int i = 0; i < size; i++) {
            Integer n = list[root].get(i);
            if (!v[n]) {
                leafNode(n);
            } else {
                if (size == 1) {
                    ans++;
                }
            }
        }
    }
}
