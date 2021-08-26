package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1527_금민수의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int i = from; i <= to; i++) {
            boolean flag = true;
            int num = i;
            while (num > 0) {
                if (num % 10 == 4 || num % 10 == 7) {
                    num = num / 10;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
