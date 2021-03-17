package algorithm;

import java.util.Scanner;

public class B17614_369 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String a1 = "3";
        String a2 = "6";
        String a3 = "9";
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            String num = Integer.toString(i);
            if (num.contains(a1) || num.contains(a2) || num.contains(a3)) {
                int bLen = num.length();
                num = num.replace(a1, "");
                num = num.replace(a2, "");
                num = num.replace(a3, "");
                int aLen = num.length();
                cnt += (bLen - aLen);

            }
        }
        System.out.println(cnt);
    }
}
