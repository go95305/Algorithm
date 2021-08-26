package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1107_리모컨 {
    static boolean channel[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        channel = new boolean[10];
        String target = br.readLine();
        int brokenChannel = Integer.parseInt(br.readLine());
        if (brokenChannel != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < brokenChannel; i++) {
                int num = Integer.parseInt(st.nextToken());
                channel[num] = true;
            }
        }
        int ans = Math.abs(100 - Integer.parseInt(target));

        for (int i = 0; i <= 888888; i++) {
            boolean flag = false;
            String tmpNum = Integer.toString(i);
            int len = tmpNum.length();
            for (int j = 0; j < len; j++) {
                int val = tmpNum.charAt(j) - '0';
                if (!check(val)) {
                    flag = true;
                    break;
                }
            }

            /** 안눌리는 숫자가 없는 채널이다.*/
            if (!flag) {
                if (ans > Math.abs(i - Integer.parseInt(target)) + len) {
                    ans = Math.abs(i - Integer.parseInt(target)) + len;
                }
            }
        }
        System.out.println(ans);

    }

    private static boolean check(int val) {
        if (channel[val]) {
            return false;
        }
        return true;
    }
}
