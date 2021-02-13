package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B2217_로프 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int rope[] = new int[N];
        for (int i = 0; i < N; i++) {
            rope[i] = sc.nextInt();
        }

        int maxRope = 0;
        Arrays.sort(rope);
        for (int i = 0; i < N; i++) {
            int curRope = rope[i];
            int ropeCnt = N - i;
            maxRope = Math.max(curRope * ropeCnt, maxRope);
        }
        System.out.println(maxRope);
    }
}
