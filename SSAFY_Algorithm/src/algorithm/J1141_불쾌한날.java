package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class J1141_불쾌한날 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Stack<Integer> st = new Stack<>();
        long ans = 0;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(in.readLine());

            while (!st.isEmpty() && st.peek() <= tmp) {
                st.pop();
            }
            ans += st.size();
            st.add(tmp);
        }
        System.out.println(ans);
    }
}
