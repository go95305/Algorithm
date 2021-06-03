package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String word = st.nextToken();
            if (word.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deq.addLast(num);
            } else if (word.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                deq.addFirst(num);
            } else if (word.equals("pop_front")) {
                if (deq.size() != 0) {
                    int num = deq.pollFirst();
                    System.out.println(num);
                } else
                    System.out.println(-1);
            } else if (word.equals("pop_back")) {
                if (deq.size() != 0) {
                    int num = deq.pollLast();
                    System.out.println(num);
                } else
                    System.out.println(-1);
            } else if (word.equals("size"))
                System.out.println(deq.size());
            else if (word.equals("empty")) {
                if (deq.size() == 0) {
                    System.out.println(1);
                } else
                    System.out.println(0);
            } else if (word.equals("front")) {
                if (deq.size() != 0) {
                    System.out.println(deq.getFirst());
                } else
                    System.out.println(-1);
            } else if (word.equals("back")) {
                if (deq.size() != 0) {
                    System.out.println(deq.getLast());
                } else
                    System.out.println(-1);
            }



        }


    }
}
