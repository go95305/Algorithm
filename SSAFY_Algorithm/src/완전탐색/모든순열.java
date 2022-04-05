package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 모든순열 {
    static int N;
    static int arr[];
    static boolean v[];
    static int sel[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }
        sel = new int[N];
        v = new boolean[N];
        permutation(0, 0);
    }

    private static void permutation(int idx, int k) {
        if (k == sel.length) {
            for (int i=0;i<sel.length;i++){
                System.out.print(sel[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!v[i]) {
                v[i] = true;
                sel[k] = arr[i];
                permutation(idx + 1, k + 1);
                v[i] = false;
            }
        }
    }
}
