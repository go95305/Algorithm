package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서강근육맨 {
    static int N;
    static long t[];
    static long sel[];
    static boolean v[];
    static long min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        t = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            t[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(t);
        long max = 0;
        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                max = Math.max(max, t[i] + t[t.length - 1 - i]);
            }
        } else {
            max = t[t.length - 1];
            for (int i = 0; i < (N-1) / 2; i++) {
                max = Math.max(max, t[i] + t[t.length - 2 - i]);
            }
        }
        System.out.println(max);

    }
}
