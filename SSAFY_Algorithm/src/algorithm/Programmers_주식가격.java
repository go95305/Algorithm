package algorithm;

import java.util.Arrays;

public class Programmers_주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new int[prices.length];

        boolean flag = false;
        for (int i = 0; i < prices.length; i++) {
            flag=false;
            int cnt = 0;
            int drop = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    drop = j - i;
                    flag = true;
                    break;
                }
                cnt++;
            }
            if (flag)
                answer[i] = drop;
            else
                answer[i] = cnt;
        }
        System.out.println(Arrays.toString(answer));
    }
}
