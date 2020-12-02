package algorithm;

import java.util.Scanner;

public class S8382_방향전환 {
    static int x1, x2, y1, y2;
    static int Ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            //x와 y중 더 가까운 곳을 찾아서 이동방향을 선정
            int xMove = Math.abs(x1 - x2);
            int yMove = Math.abs(y1 - y2);

            Ans = 0;
            if (xMove > yMove) {
                dfs(x1, y1, x2, y2, 1, 0);
            } else {
                dfs(x1, y1, x2, y2, 2, 0);
            }
            System.out.println("#" + tc + " " + Ans);


        }
    }

    private static void dfs(int x1, int y1, int x2, int y2, int dir, int cnt) {
        if (x1 == x2 && y1 == y2) {
            Ans = cnt;
            return;
        }
        if (dir == 1) {
            if (x1 < x2) {
                x1 = x1 + 1;
            } else {
                x1 = x1 - 1;
            }
        } else {
            if (y1 < y2) {
                y1 = y1 + 1;
            } else {
                y1 = y1 - 1;
            }
        }
        if (dir == 1)
            dfs(x1, y1, x2, y2,2,cnt+1 );
        else
            dfs(x1, y1, x2, y2, 1, cnt+1);
    }
}
