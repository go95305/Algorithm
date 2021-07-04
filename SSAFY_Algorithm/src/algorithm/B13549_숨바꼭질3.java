package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ForkJoinPool;

public class B13549_숨바꼭질3 {
    static class Point {
        int r, cnt;

        Point(int r, int cnt) {
            this.r = r;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, K;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Point> que = new LinkedList<>();
        que.add(new Point(N, 0));
        boolean v[][] = new boolean[2][100001];
        v[0][N] = true;
        int ans = Integer.MAX_VALUE;
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.r == K) {
                ans = p.cnt;
                break;
            }
            int front = p.r + 1;
            int back = p.r - 1;
            int fJump = p.r *= 2;
            if (fJump < 100001 && !v[1][fJump]) {
                que.add(new Point(fJump, p.cnt));
                v[1][fJump] = true;
            }
            if (back >= 0 && !v[0][back]) {
                que.add(new Point(back, p.cnt + 1));
                v[0][back] = true;
            }
            if (front < 100001 && !v[0][front]) {
                que.add(new Point(front, p.cnt + 1));
                v[0][front] = true;
            }


        }
        System.out.println(ans);


    }
}
