package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();

        Stack<Character> st = new Stack<>();


        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            if (tmp == bomb.charAt(bomb.length() - 1)) {
                if (st.size() >= bombLen - 1) {
                    int bombIdx = 0;
                    for (int j = st.size() - (bombLen - 1); j < st.size(); j++) {
                        if (st.get(j) == bomb.charAt(bombIdx)) {
                            bombIdx++;
                            if (bombIdx == bombLen - 1) {
                                for (int k = 0; k < bombLen - 1; k++) {
                                    st.pop();
                                }
                            }
                        } else {
                            st.push(tmp);
                            break;
                        }
                    }
                }else{
                    st.push(tmp);
                }
            } else {
                st.push(tmp);
            }
        }

        if (st.size() == 0) {
            System.out.println("FRULA");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < st.size(); i++) {
                stringBuilder.append(st.get(i));
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
