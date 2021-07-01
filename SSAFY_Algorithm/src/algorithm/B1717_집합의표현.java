package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현 {
    static int n, m;
    static int parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];

        for (int i=0;i<parents.length;i++){
            parents[i]=i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int task = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (task == 0) { //Union
                union(a, b);
            } else {//find
                int aParent = find(a);
                int bParent = find(b);
                if (aParent == bParent) {
                    System.out.println("YES");
                } else
                    System.out.println("NO");
            }
        }


    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x < y) {
            parents[y] = x;
        } else
            parents[x] = y;
    }

    private static int find(int num) {
        if (parents[num] == num) {
            return num;
        }
        return parents[num] = find(parents[num]);
    }
}
