package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11478_서로다른부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        Set<String> st = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.length() - i; j++) {
                String newWord = word.substring(j, j + i + 1);
                st.add(newWord);
            }
        }
        System.out.println(st.size());

    }
}

/*
(0,1) (1)
 */
