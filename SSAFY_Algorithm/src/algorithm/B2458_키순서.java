package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2458_키순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int map[][] = new int[N][N];
        int INF = 9999999;
        for (int i = 0; i < N; i++)
            Arrays.fill(map[i], INF);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            map[from][to] = 1;
        }


        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (k == i) continue;
                for (int j = 0; j < N; j++) {
                    if (i == j || k == j) continue;
                    if (map[i][k] + map[k][j] < map[i][j])
                        map[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == INF)
                    map[i][j] = 0;
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    sum += map[i][j];
                    sum += map[j][i];

                }
            }
            sum += map[i][i];
            if (sum == N - 1)
                ans++;
        }
        System.out.println(ans);
    }
}
