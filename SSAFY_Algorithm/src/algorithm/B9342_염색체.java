package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9342_염색체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < N; tc++) {
            char before = 'a';
            String dna = br.readLine();
            boolean flag = true;
            for (int i = 0; i < dna.length(); i++) {
                if (i > 0) {
                    if (before == 'A') {
                        if (dna.charAt(i) != 'A' && dna.charAt(i) != 'F') {
                            flag = false;
                            break;
                        }
                    } else if (before == 'F') {
                        if (dna.charAt(i) != 'F' && dna.charAt(i) != 'C') {
                            flag = false;
                            break;
                        }
                    } else if (before == 'C') {
                        if (dna.charAt(i) != 'C') {
                            if (i != dna.length() - 1) {
                                flag = false;
                                break;
                            } else if (i == dna.length() - 1) {
                                if (dna.charAt(i)!='A' || dna.charAt(i)!='B'||dna.charAt(i)!='C'||dna.charAt(i)!='D'||dna.charAt(i)!='E'||dna.charAt(i)!='F'){
                                    flag=false;
                                    break;
                                }
                            }
                        }
                    }
                }
                before = dna.charAt(i);
            }
            if (!flag)
                System.out.println("Good");
            else
                System.out.println("Infected!");
        }
    }
}
