package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/** 슬라이딩 윈도우*/
public class B20437_문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int ansThree = Integer.MAX_VALUE;
            int ansFour = 0;
            String W = br.readLine();
            int chk[] = new int[26];
            for (int i = 0; i < W.length(); i++) {
                chk[W.charAt(i) - 'a']++;
            }

            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < W.length(); i++) {
                if (chk[W.charAt(i) - 'a'] >= K) {
                    int cnt = 0;
                    for (int j = i; j < W.length(); j++) {
                        if (W.charAt(i) == W.charAt(j))
                            cnt++;

                        if (cnt == K) {
                            ansThree = Math.min(ansThree, j - i + 1);
                            ansFour = Math.max(ansFour, j - i + 1);
                            break;
                        }
                    }
                }
            }
            if (ansThree != Integer.MAX_VALUE)
                System.out.println(ansThree + " " + ansFour);
            else
                System.out.println(-1);
        }

    }
}
