package algorithm;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < N; tc++) {
            Stack<Character> st = new Stack<>();
            String tmp = br.readLine();

            for (int i = 0; i < tmp.length(); i++) {
                char gwalho = tmp.charAt(i);
                if (st.isEmpty())
                    st.add(gwalho);
                else {
                    if (st.peek() == '(' && gwalho == ')')
                        st.pop();
                    else
                        st.add(gwalho);
                }
            }
            if(st.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
