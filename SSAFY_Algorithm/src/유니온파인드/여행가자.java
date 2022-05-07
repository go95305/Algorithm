package 유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 여행가자 {
    static int N, M;
    static int parent[];
    static int path[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");//0 1 0
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    union(i, j);

                }
            }
        }
//        System.out.println(Arrays.toString(parent));
        path = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            path[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        checkPath();

    }

    private static void checkPath() {
        for (int i = 0; i < M - 1; i++) {
            int a = find(path[i]);
            int b = find(path[i + 1]);
            if (a!=b) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        return;
    }


    private static void union(int x, int y) {
        int a = find(x);//1
        int b = find(y);//1
        if (a < b)
            parent[a] = b;
        else
            parent[b] = a;
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
}
