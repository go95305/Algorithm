package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B5618_공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ar[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
            if (ar[i] < min)
                min = ar[i];
        }
        for (int i = 1; i <= min; i++) {
            boolean flag = true;
            for (int j = 0; j < ar.length; j++) {
                if (ar[j] % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println(i);
        }
    }
}
