package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < N; i++) {
            boolean flag = true;
            boolean alph[] = new boolean[26];
            String word = br.readLine();
            char before = 'a';
            for (int j = 0; j < word.length(); j++) {
                char each = word.charAt(j);
                if (j == 0) {
                    before = each;
                    alph[each - 'a'] = true;
                } else {
                    if (alph[each - 'a']) {
                        if (before != each) {
                            flag = false;
                            break;
                        }
                    } else {
                        alph[each - 'a'] = true;
                        before = each;
                    }
                }
            }
            if (flag)
                ans++;
        }
        System.out.println(ans);
    }
}
