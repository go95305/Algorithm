package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609_회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < N; tc++) {
            String tmp = br.readLine();
            char[] word = tmp.toCharArray();
            char[] backward = new char[word.length];
            int idx = 0;
            for (int i = word.length - 1; i >= 0; i--) {
                backward[i] = word[idx++];
            }

            //차이가 1나만 나도 가능성이 있지만 그보다많이 나면 무조건 불가
            int diff = 0;
            boolean flag = true;
            //각 문자르 비교
            for (int i = 0; i < word.length; i++) {
                char tmp1 = word[i];
                char tmp2 = backward[i];
                if (tmp1 != tmp2) {
                    diff++;
                    //각각을 지워보며 회문되는지 확인
                    flag = wordMatch(word, backward, i);
                    break;
                }
            }
            if (flag && diff == 0)
                System.out.println(0);
            else if (flag && diff == 1)
                System.out.println(1);
            else
                System.out.println(2);
        }
    }

    private static boolean wordMatch(char[] word, char[] backward, int idx) {
        StringBuilder testWord1 = new StringBuilder();
        StringBuilder testWord2 = new StringBuilder();

        //word에서 문자를 지울 경우
        for (int i = 0; i < word.length; i++) {
            if (i != idx)
                testWord1.append(word[i]);
        }

        for (int i = 0; i < backward.length; i++) {
            if (i != (backward.length-1) - idx)
                testWord2.append(backward[i]);
        }

        if (testWord1.toString().equals(testWord2.toString()))
            return true;

        //backward에서 문자를 지운 경우
        testWord1 = new StringBuilder();
        testWord2 = new StringBuilder();

        for (int i = 0; i < word.length; i++) {
            if (i != (word.length-1) - idx)
                testWord1.append(word[i]);
        }

        for (int i = 0; i < backward.length; i++) {
            if (i != idx)
                testWord2.append(backward[i]);
        }
        if (testWord1.toString().equals(testWord2.toString()))
            return true;

        return false;

    }
}
