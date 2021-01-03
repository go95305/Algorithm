package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697_숨바꼭질 {
    static int Ans;

    static class Point {
        int r, move;

        Point(int r, int move) {
            this.r = r;
            this.move = move;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean v[] = new boolean[100001];
        Ans = Integer.MAX_VALUE;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(N, 0));
        v[N] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.r == K) {
                Ans = Math.min(Ans, p.move);
                break;
            }
            if (2 * p.r <= 100000 && !v[2 * p.r]) {
                v[2 * p.r] = true;
                que.add(new Point(2 * p.r, p.move + 1));
            }
            if (p.r + 1 <= 100000 && !v[p.r + 1]) {
                v[p.r + 1] = true;
                que.add(new Point(p.r + 1, p.move + 1));
            }
            if (p.r - 1 >= 0 && !v[p.r - 1]) {
                v[p.r - 1] = true;
                que.add(new Point(p.r - 1, p.move + 1));
            }

        }
        System.out.println(Ans);
    }
}
