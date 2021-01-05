package algorithm;

import java.util.Arrays;

public class Programmers_이진변환반복하기 {
    public static void main(String[] args) {
        String s = "110010101001";
        int[] answer = {};
        int cnt = 1;
        int zero = 0;
        while (true) {
            // 0제거
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                }
            }
            s = s.replace("0", "");
            //길이
            int len = s.length();
            //이진수 변환

            System.out.println(s);
            //1인지 검사
            if (s.equals("1")) {
                break;
            } else {
                cnt++;
            }
        }
        answer = new int[2];
        answer[0] = cnt;
        answer[1] = zero;
        System.out.println(Arrays.toString(answer));
    }
}
