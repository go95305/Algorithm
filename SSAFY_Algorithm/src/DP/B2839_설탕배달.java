package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B2839_설탕배달 {
    static class Point {
        int num, cnt;

        Point(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];
        arr[3] = 1;
        arr[5] = 1;
        for (int i = 6; i < N + 1; i++) {
            if (arr[i - 3] > 0) {
                arr[i] = arr[i - 3] + 1;
            }

            if (arr[i - 5] > 0) {
                arr[i] = arr[i] > 0 ? Math.min(arr[i - 5] + 1, arr[i]) : arr[i - 5] + 1;
            }
        }
        if (arr[N] == 0)
            System.out.println(-1);
        else
            System.out.println(arr[N]);

    }
}
