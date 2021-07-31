package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11052_카드구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++)
            card[i] = Integer.parseInt(st.nextToken());

        int[] price = new int[N + 1];
        if (N == 1)
            System.out.println(card[1]);
        else {
            price[1] = card[1]; //1
            price[2] = Math.max(card[2], price[1] * 2);
            for (int i = 3; i < N + 1; i++) {
                int large = getBig(i, price, card[i]);
                if (i % 2 == 0) {
                    int mid = price[i / 2] * 2;
                    price[i] = Math.max(large, mid);
                } else {
                    price[i] = large;
                }
            }
            System.out.println(price[N]);
        }
    }

    private static int getBig(int idx, int[] price, int max) {
        int start = 1;
        int end = idx - 1;
        while (start < end) {
            int sum = price[start] + price[end];
            max = Math.max(max, sum);
            start++;
            end--;
        }
        return max;
    }
}