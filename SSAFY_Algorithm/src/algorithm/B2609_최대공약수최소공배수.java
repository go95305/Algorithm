package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2609_최대공약수최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a < b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        int multiple = a*b;
        int n = 0;
        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
        }

        System.out.println(a);
        System.out.println(multiple/a);
    }
}
