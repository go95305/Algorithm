package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class S4008_숫자만들기 {
    static int N, num[];
    static int operator[];
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            operator = new int[4];// +-/*연산자를 집어넣을 배열
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < 4; i++) {
                operator[i] = Integer.parseInt(st.nextToken());
            }
            num = new int[N];
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            permutation(num[0], 1);
            System.out.println("#" + tc + " " + (max - min));
        }
    }

    private static void permutation(int ans, int idx) {

        if (idx == N) {
            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                if (i == 0)
                    permutation(ans + num[idx], idx + 1);
                else if (i == 1)
                    permutation(ans - num[idx], idx + 1);
                else if (i == 2)
                    permutation(ans * num[idx], idx + 1);
                else
                    permutation(ans / num[idx], idx + 1);
                operator[i]++;
            }
        }
    }


}
