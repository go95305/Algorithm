package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6550_부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while (((input = br.readLine()) != null)) {
            StringTokenizer st = new StringTokenizer(input);
            String s = st.nextToken();
            String t = st.nextToken();
            int cur = 0;
            int size = s.length();
            int idx = 0;
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == s.charAt(idx)) {
                    idx++;
                    cur++;
                    if (cur == size)
                        break;
                }
            }
            if (size == cur)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
