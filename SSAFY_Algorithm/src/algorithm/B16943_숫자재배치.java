package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16943_숫자재배치 {
    static int ans;
    static int sel[];
    static boolean v[];
    static int num[];
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        char A[] = st.nextToken().toCharArray();
        B = Integer.parseInt(st.nextToken());

        num = new int[A.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = A[i] - '0';
        }

        ans = Integer.MIN_VALUE;
        sel = new int[num.length];
        v = new boolean[num.length];
        permutation(0);
        if (ans == Integer.MIN_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);

    }

    private static void permutation(int k) {
        if (k == sel.length) {
            if (sel[0] == 0)
                return;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sel.length; i++) {
                sb.append(sel[i]);
            }

            if (Integer.parseInt(sb.toString()) < B) {
                if (ans < Integer.parseInt(sb.toString()))
                    ans = Integer.parseInt(sb.toString());
            }
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (!v[i]) {
                v[i] = true;
                sel[k] = num[i];
                permutation(k + 1);
                v[i] = false;
            }
        }
    }
}
