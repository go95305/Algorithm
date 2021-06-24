package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10870_피보나치수5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[1001];
        arr[0] = 0;
        arr[1] = 1;

        if (n == 0)
            System.out.println(0);
        else if (n == 1)
            System.out.println(1);
        else {
            for (int i = 2; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            System.out.println(arr[n]);
        }

    }
}
