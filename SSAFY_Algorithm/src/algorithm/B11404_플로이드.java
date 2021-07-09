package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11404_플로이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int map[][] = new int[n][n];
        int max = 99999999;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            if (map[from][to] != 0)
                map[from][to] = Math.min(map[from][to], weight);
            else
                map[from][to] = weight;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && map[i][j] == 0) {
                    map[i][j] = max;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k)
                    continue;//경유지와 출발지가 달라야한다.
                for (int j = 0; j < n; j++) {
                    if (k == j || i == j)
                        continue;
                    if (map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (map[i][j]==max)
                    map[i][j]=0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != n - 1)
                    System.out.print(map[i][j] + " ");
                else
                    System.out.println(map[i][j]);
            }
        }
    }
}
