package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B9205_맥주마시면서걸어가기 {
    static boolean v[];
    static int N;
    static Point festival;
    static int ans;

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            v = new boolean[N];
            ArrayList<Point> list = new ArrayList<>();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int endX = 0;
            int endY = 0;
            for (int i = 0; i < N + 1; i++) {
                list.add(new Point(sc.nextInt(), sc.nextInt()));
                if (i == N) {
                    endX = list.get(i).r;
                    endY = list.get(i).c;
                }
            }
            boolean v[] = new boolean[N+1];
            ans = -1;
            Queue<Point> que = new LinkedList<>();
            que.add(new Point(x, y));
            while (!que.isEmpty()) {
                //peek을 통해 갈수 있는 편의점이면 poll 아니면 넘어간다.
                Point p = que.poll();
                if (p.r == endX && p.c == endY) {
                    ans = 1;
                    break;
                }
                for (int i = 0; i < list.size(); i++) {
                    if (!v[i] && Math.abs(p.r - list.get(i).r) + Math.abs(p.c - list.get(i).c) <= 1000) {
                        v[i] = true;
                        que.add(new Point(list.get(i).r, list.get(i).c));
                    }
                }
            }
            //전부 poll을 하고 festival이랑 위치 비교해서 1000이하면 happy
            if (ans == -1)
                System.out.println("sad");
            else
                System.out.println("happy");
        }
    }


}
