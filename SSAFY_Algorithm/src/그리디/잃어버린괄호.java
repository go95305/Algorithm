package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] mod = str.split("-");
        int start = 0;
        for (int i = 0; i < mod.length; i++) {
            int sum = 0;
            String[] tmp = mod[i].replace("+", " ").split(" ");
            for (int j = 0; j < tmp.length; j++) {
                sum += Integer.parseInt(tmp[j]);
            }
            if (i == 0) {
                start = sum;
            } else {
                start -= sum;
            }
        }
        System.out.println(start);


    }
}
