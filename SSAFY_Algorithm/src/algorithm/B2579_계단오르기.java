package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int step[] = new int[N + 1];

        step[1] = arr[1];
        step[2] = arr[1] + arr[2];

        for (int i = 3; i <= N; i++) {
            step[i] = Math.max(step[i - 3] + arr[i - 1], step[i - 2]) + arr[i];
        }
        System.out.println(step[N]);
    }
}
