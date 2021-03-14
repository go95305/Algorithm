package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B9613_GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long GCD_sum = 0;
            int N = sc.nextInt();
            int arr[] = new int[N];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }
            for (int j = 0; j < N; j++) {
                int num = arr[j];
                int a = 0;
                int b = 0;
                for (int t = j + 1; t < N; t++) {
                    if (num > arr[t]) {
                        a = num;
                        b = arr[t];
                    }else{
                        a = arr[t];
                        b = num;
                    }
                    GCD_sum += getGCD(a, b);
                }
            }
            System.out.println(GCD_sum);

        }
    }

    private static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
