package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ar[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        int max = ar[0];
        for (int i = 1; i < N; i++) {
            int sum = ar[i - 1] + ar[i];
            if (sum > ar[i]) { // 현재+이전 > 현재
                ar[i] = sum;
                max = Math.max(max, ar[i]);
            }else{
                max = Math.max(max,ar[i]);
            }
        }
        System.out.println(max);

    }
}
