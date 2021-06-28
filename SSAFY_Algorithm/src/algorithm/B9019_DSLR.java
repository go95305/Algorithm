package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9019_DSLR {
    static class Point {
        int word;
        String step;


        Point(int word, String step) {
            this.word = word;
            this.step = step;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            boolean v[] = new boolean[10000];
            int B = Integer.parseInt(st.nextToken());
            Queue<Point> que = new LinkedList<>();
            que.add(new Point(A, ""));
            String[] alphabet = {"L", "R", "D", "S"};
            while (!que.isEmpty()) {
                Point p = que.poll();
                if (p.word == B) {
                    System.out.println(p.step);
                    break;
                }
                //D연산
                int D = p.word * 2;
                if (D > 9999)
                    D %= 10000;
                if (!v[D]) {
                    v[D] = true;
                    que.add(new Point(D, p.step + alphabet[2]));
                }

                //S연산
                int S = 0;
                if (p.word == 0) {
                    S = 9999;
                } else {
                    S = p.word - 1;
                }
                if (!v[S]) {
                    que.add(new Point(S, p.step + alphabet[3]));
                }
                //L연산
                int L = p.word % 1000 * 10 + p.word / 1000;
                if (!v[L]) {
                    v[L] = true;
                    que.add(new Point(L, p.step + alphabet[0]));
                }

                //R연산
                int R = p.word % 10 * 1000 + p.word / 10;
                if (!v[R]) {
                    v[R] = true;
                    que.add(new Point(R, p.step + alphabet[1]));
                }
            }
        }
    }
}
