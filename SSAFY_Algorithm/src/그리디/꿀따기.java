package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 꿀따기 {
    static int N;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int sum[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            if (i > 0)
                sum[i] = sum[i - 1] + val;
            else
                sum[i] = val;
        }

        int max = 0;//update max  value

        for (int i = 1; i < N - 1; i++) {
            //bee1 - bee2 - honey
            int bee1 = sum[N - 1] - arr[0] - arr[i];
            int bee2 = sum[N - 1] - sum[i];
            max = Math.max(max, bee1 + bee2);

            //honey - bee1 - bee2
            bee1 = sum[i - 1];
            bee2 = sum[N - 2] - arr[i];
            max = Math.max(max, bee1 + bee2);

            //bee1 - honey - bee2
            bee1 = sum[i] - arr[0];
            bee2 = sum[N - 2] - sum[i - 1];
            max = Math.max(max, bee1 + bee2);
        }
        System.out.println(max);
    }
}
