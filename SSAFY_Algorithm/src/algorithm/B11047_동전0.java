package algorithm;

import java.util.Scanner;

public class B11047_동전0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int ans = 0;
        int coins[] = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        for (int i = coins.length - 1; i >= 0; i--) {
            int divided = coins[i];
            if (K / divided > 0) {
                ans += (K / divided);
                K = K % divided;
            }
        }
        System.out.println(ans);
    }
}
