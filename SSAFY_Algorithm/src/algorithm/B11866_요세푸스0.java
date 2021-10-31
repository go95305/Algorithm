package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11866_요세푸스0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();
        int idx = 1;
        while (que.size() > 0) {
            Integer num = que.poll();
            if (idx == K) {
                idx = 1;
                list.add(num);
                continue;
            }
            que.add(num);
            idx++;
        }
        System.out.print("<");
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1)
                System.out.print(list.get(i) + ", ");
            else
                System.out.print(list.get(i));
        }
        System.out.println(">");

    }
}
