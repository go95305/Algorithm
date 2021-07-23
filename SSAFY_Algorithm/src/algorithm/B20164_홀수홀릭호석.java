package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20164_홀수홀릭호석 {
    static String num;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = br.readLine();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        disect(num, 0);
        System.out.println(min+" "+max);
    }

    private static void disect(String num, int cnt) {
        if (num.length() == 1) {
            cnt += findOdd(num);
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
        } else if (num.length() == 2) {
            cnt += findOdd(num);
            int first = num.charAt(0) - '0';
            int last = num.charAt(1) - '0';
            int sum = first + last;
            disect(Integer.toString(sum), cnt);
        } else if (num.length()>=3){
            cnt += findOdd(num);
            for (int i = 1; i < num.length(); i++) {
                for (int j = i + 1; j < num.length(); j++) {
                    int first = Integer.parseInt(num.substring(0, i));
                    int second = Integer.parseInt(num.substring(i, j));
                    int third = Integer.parseInt(num.substring(j));
                    int sum = first + second + third;
                    disect(Integer.toString(sum), cnt);
                }
            }
        }
    }

    private static int findOdd(String num) {
        int cnt = 0;
        for (int i = 0; i < num.length(); i++) {
            int tmp = num.charAt(i) - '0';
            if (tmp % 2 != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
