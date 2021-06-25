package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15724_주지수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }


        int k = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < k; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int lr = Integer.parseInt(st.nextToken());
            int lc = Integer.parseInt(st.nextToken());
            int rr = Integer.parseInt(st.nextToken());
            int rc = Integer.parseInt(st.nextToken());

            int sum = (map[rr][rc] - map[lr - 1][rc]) - (map[rr][lc - 1] - map[lr - 1][lc - 1]);
            System.out.println(sum);
        }
    }
}
