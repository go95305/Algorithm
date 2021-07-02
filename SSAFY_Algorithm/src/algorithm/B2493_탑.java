package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑 {
    static class Tower {
        int height, idx;

        Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                stack.push(new Tower(value, i));
                System.out.print(0 + " ");
            } else {
                if (stack.peek().height >= value) {
                    System.out.print(stack.peek().idx + " ");
                    stack.push(new Tower(value, i));
                } else {
                    while (stack.peek().height < value) {
                        stack.pop();
                        if (stack.size() == 0)
                            break;
                    }
                    if (stack.size() == 0) {
                        System.out.print(0 + " ");
                    } else {
                        System.out.print(stack.peek().idx + " ");
                    }
                    stack.push(new Tower(value, i));
                }
            }

//            if (stack.size() == 1) {
//                System.out.print(0 + " ");
//            } else {
//                System.out.print(stack.peek().idx + " ");
//            }

        }
    }
}
