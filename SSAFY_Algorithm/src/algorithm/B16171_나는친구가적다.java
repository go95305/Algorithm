package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16171_나는친구가적다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String unCorrect = br.readLine();
        String correct = br.readLine();

        //숫자 제거
        String erased = eraseNum(unCorrect);
        if (erased.contains(correct))
            System.out.println(1);
        else
            System.out.println(0);
    }

    private static String eraseNum(String unCorrect) {
        for (int i = 0; i <= 9; i++) {
            String alph = Integer.toString(i);
            if (unCorrect.contains(alph))
                unCorrect = unCorrect.replace(alph, "");
        }
        return unCorrect;

    }
}
