package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2812_크게만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        String tmp = st.nextToken();

        //1. 우선 숫자를 queue에 넣는다.
        for (int i = 0; i < N; i++) {
            que.add(tmp.charAt(i) - '0');
        }

        Stack<Integer> stack = new Stack();
        int outCnt = 0;
        while (!que.isEmpty()) {
            int num = que.poll();
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                if (stack.peek() < num) {
                    while (!stack.isEmpty() && stack.peek() < num) {
                        if (outCnt == K)
                            break;
                        stack.pop();
                        outCnt++;
                    }
                    stack.push(num);
                } else {
                    stack.push(num);
                }
            }
            if (outCnt == K)
                break;

        }
        if (stack.size() < (N - K)) {
            int cnt = (N - K) - stack.size();
            for (int i = 0; i < cnt; i++)
                stack.push(que.poll());
        }
        int cnt = stack.size() - (N - K);
        for (int j = 0; j < cnt; j++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < stack.size(); j++) {
            sb.append(stack.get(j));
        }
        System.out.println(sb);
    }



}
