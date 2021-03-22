package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B16198_에너지모으기 {
    static int N;
    static List<Integer> list;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        ans = 0;
        dfs(0);
        System.out.println(ans);

    }

    private static void dfs(int sum) {
        if (list.size() == 2) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int energy = list.get(i);
            int nextSum = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            dfs(sum + nextSum);
            list.add(i, energy);
        }
    }
}
