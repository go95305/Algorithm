package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;

public class 회문은회문이아니야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char str[] = br.readLine().toCharArray();
        int ans = 0;
        int len = str.length;
        for (int i = 0; i < len / 2; i++) {
            if (str[i] != str[len - i - 1]) {
                ans = len - i;
                break;
            }
        }
        if (ans == 0) {//회문
            if (str[0] == str[len / 2]) {
                System.out.println(-1);
            } else {
                System.out.println(len - 1);
            }
        } else { // 회문 아닐경우
            System.out.println(len);
        }


    }
}
