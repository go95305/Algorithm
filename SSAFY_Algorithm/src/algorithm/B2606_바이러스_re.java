package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Union-find로 풀기
 */
public class B2606_바이러스_re {
    static int N, M;
    static int parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            union(a, b);
        }
        int ans = 0;
        for (int i = 1; i < parents.length; i++) {
            if (find(i) == find(0))
                ans++;
        }
        System.out.println(ans);
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            if (x < y) {
                parents[y] = x;
            } else {
                parents[x] = y;
            }
        }
    }

    private static int find(int num) {
        if (parents[num] == num)
            return num;
        return parents[num] = find(parents[num]);

    }
}
