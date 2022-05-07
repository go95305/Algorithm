package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 여우는어떻게울지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String Wolf = br.readLine();
            String bark[] = Wolf.split(" ");
            while (true) {
                String word = br.readLine();
                if (word.equals("what does the fox say?")) {
                    break;
                }

                String barf[] = word.split(" ");
                for (int j = 0; j < bark.length; j++) {
                    for (int k = 0; k < barf.length; k++) {
                        if (bark[j].equals(barf[k]))
                            bark[j] = "";
                    }
                }
            }
            for (int k = 0; k < bark.length; k++) {
                if (bark[k] != "")
                    System.out.print(bark[k] + " ");
            }
        }
    }
}
