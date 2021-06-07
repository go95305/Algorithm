package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B212_8진수2진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            String ans = "";
            int eight = num.charAt(i) - '0';

            for (int j = 0; j < 2; j++) {
                int two = eight % 2;
                eight /= 2;
                ans = two + ans;
            }

            ans = eight + ans;
            sb.append(ans);
        }
        char[] ans = sb.toString().toCharArray();
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == '0')
                ans[i] = '2';
            else
                break;
        }
        sb =new StringBuilder();
        for (int i=0;i<ans.length;i++){
            if(ans[i]!='2')
                sb.append(ans[i]);
        }

        if (num.equals("0"))
            System.out.println(0);
        else
            System.out.println(sb);

    }
}
