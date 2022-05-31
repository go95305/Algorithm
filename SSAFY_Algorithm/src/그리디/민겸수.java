package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 민겸수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder mval = new StringBuilder();
        StringBuilder lval = new StringBuilder();
        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'M') {
                mval.append(1);
                lval.append(1);
            } else {
                if (mval.length() > 0) {
                    max.append(5);
                    for (int k = 0; k < mval.length(); k++) {
                        max.append(0);
                    }

                    min.append(1);
                    for (int k = 0; k < lval.length()-1; k++) {
                        min.append(0);
                    }
                    min.append(5);
                } else {
                    max.append(5);
                    min.append(5);
                }
                mval = new StringBuilder();
                lval = new StringBuilder();
            }
        }

        if (mval.length() > 0) {
            min.append(1);
            for (int i = 0; i < lval.length()-1; i++) {
                min.append(0);
            }
            for (int i = 0; i < mval.length(); i++) {
                max.append(1);
            }
        }

        System.out.println(max);
        System.out.println(min);


    }
}
