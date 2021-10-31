package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class B12919_A와B2 {
    static String str1;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        flag = false;
        String str2 = br.readLine();
        isPos(str2);
        if (flag)
            System.out.println(1);
        else
            System.out.println(0);

    }

    private static void isPos(String word) {
        if (word.length() == str1.length()) {
            if (isSame(word)) {
                flag = true;
            }
            return;
        }
        if (word.charAt(0) == 'B')
            isPos(eraseB(word));
        if (word.charAt(word.length() - 1) == 'A')
            isPos(eraseA(word));


    }

    private static String eraseB(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = word.length() - 1; i > 0; i--)
            sb.append(word.charAt(i));
        return sb.toString();
    }

    private static String eraseA(String word) {
        return word.substring(0, word.length() - 1);
    }

    private static boolean isSame(String str2) {
        if (str2.equals(str1))
            return true;
        else
            return false;
    }
}