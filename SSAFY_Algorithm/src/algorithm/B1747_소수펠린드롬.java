package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1747_소수펠린드롬 {
    static boolean prime[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        prime = new boolean[4000001];
        eratos(4000000);

        while (true) {
            int s = 0;
            int e = N.length() - 1;

            //펠린드롬인지 판별
            boolean flag = pelidrom(s, e, N);
            if (flag) {
                //소수 판별
                if (!prime[Integer.parseInt(N)]) {
                    System.out.println(N);
                    break;
                }
            }
            int tmp = Integer.parseInt(N) + 1;
            N = Integer.toString(tmp);
        }
    }

    private static void eratos(int n) {
        int num = n;
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= num; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= num; j += i)
                    prime[j] = true;
            }
        }
    }

    private static boolean pelidrom(int s, int e, String n) {
        while (s <= e) {
            if (n.charAt(s) == n.charAt(e)) {
                s++;
                e--;
            } else {
                return false;
            }
        }
        return true;
    }
}
