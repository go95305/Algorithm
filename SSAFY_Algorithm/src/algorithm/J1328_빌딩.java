package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class J1328_빌딩 {
    static class Point {
        int value, idx;

        Point(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int ans[] = new int[N+1];
        Stack<Point> st = new Stack<>();
        for (int i = 1; i <= N; i++) {
            int tmp = Integer.parseInt(in.readLine());
            while (!st.isEmpty() && st.peek().value < tmp) {
                ans[st.peek().idx] = i;
                st.pop();
            }
            st.push(new Point(tmp, i));
        }
        for (int i = 1; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}