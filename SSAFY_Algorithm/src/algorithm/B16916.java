package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B16916 {
    static List<Integer> list[];
    static boolean v[];
    static int ans;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            v = new boolean[N];
            list = new ArrayList[N];
            for (int i = 0; i < N; i++)
                list[i] = new ArrayList<>();

            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                list[to].add(from);
            }
            ans = 0;
            flag = false;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int one = Integer.parseInt(st.nextToken()) - 1;
            int two = Integer.parseInt(st.nextToken()) - 1;
            v[one] = true;
            dfs(one);
            v[two]=true;
            parent(two);
            System.out.println(ans+1);
        }
    }

    private static void parent(int two) {
        int size = list[two].size();
        for (int i = 0; i < size; i++) {
            int num = list[two].get(i);
            if (!v[num]) {
                v[num] = true;
                parent(num);
                if (flag)
                    return;
            } else {
                ans = num;
                flag = true;
                return;
            }
        }
    }

    private static void dfs(int one) {
        int size = list[one].size();
        for (int i = 0; i < size; i++) {
            int num = list[one].get(i);
            if (!v[num]) {
                v[num] = true;
                dfs(num);
            }
        }
    }

}
