package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2 {
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        flag = false;
        dfs(T, S);
        System.out.println(0);
    }

    private static void dfs(String cur, String target) {
        if (cur.length() == target.length()) {
            if (cur.equals(target)) {
                System.out.println(1);
                System.exit(0);
            } else
                return;

        }
        String word = cur;
        if (word.charAt(word.length() - 1) == 'A') {
            word = word.substring(0, word.length() - 1);
            dfs(word, target);
        }

        String tmp = "";
        for (int i = cur.length() - 1; i >= 0; i--) {
            tmp += cur.charAt(i);
        }

        if (tmp.charAt(tmp.length() - 1) == 'B') {
            tmp = tmp.substring(0, tmp.length() - 1);
            dfs(tmp, target);
        }
    }
}
