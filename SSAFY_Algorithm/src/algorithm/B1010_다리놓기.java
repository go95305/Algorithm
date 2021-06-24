package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1010_다리놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int arr[][] = new int[30][30];
            for (int i = 0; i < 30; i++) {
                arr[i][0] = 1;
                arr[i][i] = 1;
            }
            for (int i = 2; i < 30; i++) {
                for (int j = 1; j < 30; j++) {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
            System.out.println(arr[M][N]);
        }
    }
}
