package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4659_비밀번호발음하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char look[] = {'a', 'e', 'i', 'o', 'u'};
        while (true) {
            String word = br.readLine();
            if (word.equals("end"))
                break;
            boolean v = isValid(word, look);
            if (v)
                System.out.println("<" + word + "> " + "is " + "acceptable.");
            else
                System.out.println("<" + word + "> " + "is " + "not " + "acceptable.");
        }
    }

    //houctuh
    private static boolean isValid(String word, char[] look) {
        int jaeum = 0;
        char bWord = 'a';
        int jStric = 0;
        int mStric = 0;
        for (int i = 0; i < word.length(); i++) {
            char dan = word.charAt(i);
            if (i == 0) {
                if (isLook(dan, look)) {
                    jaeum++;
                    jStric++;
                } else {
                    mStric++;//1
                }
                bWord = dan;//w
            } else {
                if (isLook(dan, look)) {
                    mStric = 0;
                    jStric++;//2
                    jaeum++;//2
                    if (bWord==dan) {
                        if (!(bWord == 'e' && dan == 'e') && !(bWord == 'o' && dan == 'o')) {
                            return false;
                        }
                    }
                    if (jStric == 3) {
                        return false;
                    }
                } else {
                    jStric = 0;
                    mStric++;
                    if (bWord==dan) {
                        if (!(bWord == 'e' && dan == 'e') && !(bWord == 'o' && dan == 'o')) {
                            return false;
                        }
                    }
                    if (mStric == 3) {
                        return false;
                    }
                }
                bWord = dan;
            }
        }
        if (jaeum == 0)
            return false;
        else
            return true;
    }

    private static boolean isLook(char dan, char[] look) {
        for (int i = 0; i < look.length; i++) {
            if (look[i] == dan)
                return true;
        }
        return false;
    }
}
