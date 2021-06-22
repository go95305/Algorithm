package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B17406_배열돌리기6 {
    static int N, M, K;
    static int map[][];
    static boolean v[];
    static int sel[];
    static int ans;
    static List<Point> list;
    static int dr[] = {0, 1, 0, -1}; //우 하 좌 상 순이다.
    static int dc[] = {1, 0, -1, 0};

    static class Point {
        int r, c, s;

        Point(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        sel = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList<>();
        v = new boolean[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.add(new Point(r, c, s));

        }
        ans = Integer.MAX_VALUE;
        permutation(0, 0);
        System.out.println(ans);
    }

    private static void permutation(int idx, int k) {
        if (k == sel.length) {
            spin(sel);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!v[i]) {
                v[i] = true;
                sel[k] = i;
                permutation(idx + 1, k + 1);
                v[i] = false;
            }
        }
    }

    private static void spin(int[] sel) {
        int[][] copy = new int[N][];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        for (int i = 0; i < sel.length; i++) {
            Point p = list.get(sel[i]);


            //좌상 좌표
            int lr = (p.r - p.s) - 1;
            int lc = (p.c - p.s) - 1;
            //우하 좌표
            int rr = (p.r + p.s) - 1;
            int rc = (p.c + p.s) - 1;

            while ( !(lr >= rr)) {

                //처음에는 우로 시작한다.
                move(lr, lc, rr, rc, 0, copy[lr][lc], lr, lc + 1, copy);
                //회전 한번 끝나면 좌표바꿔서 내부에서 다시 회전하기 위해 좌표 변경
                lr++;
                lc++;
                rr--;
                rc--;
            }
        }


        //회전을 다 끝냈으면 배열의 값을 구해야한다.
        //각 행의 합중 제일 작은값.
        int value = minArray(copy);
        ans = Math.min(ans, value);
    }

    private static int minArray(int[][] copy) {
        int maxValue = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += copy[i][j];
            }
            maxValue = Math.min(maxValue, sum);
        }
        return maxValue;
    }

    private static void move(int lr, int lc, int rr, int rc, int dir, int value, int nr, int nc, int[][] copy) {


        int next = copy[nr][nc]; //
        copy[nr][nc] = value;
        if (nr == lr && nc == lc) {
            return;
        }
        if (dir == 0) {
            if (nc + 1 <= rc) {//우로 이동하는데 범위에 안벗어났으면
                move(lr, lc, rr, rc, dir, next, nr, nc + 1, copy);
            } else { //우로 이동하는데 범위 초과면 아래로 이동한다.
                move(lr, lc, rr, rc, 1, next, nr + 1, nc, copy);
            }
        } else if (dir == 1) {
            if (nr + 1 <= rr) {//아래로 이동하는데 범위에 안벗어났으면
                move(lr, lc, rr, rc, dir, next, nr + 1, nc, copy);
            } else { //아래로 이동하는데 범위 초과면 좌 이동한다.
                move(lr, lc, rr, rc, 2, next, nr, nc - 1, copy);
            }
        } else if (dir == 2) {
            if (nc - 1 >= lc) {//좌로 이동하는데 범위에 안벗어났으면
                move(lr, lc, rr, rc, dir, next, nr, nc - 1, copy);
            } else { //우로 이동하는데 범위 초과면 아래로 이동한다.
                move(lr, lc, rr, rc, 3, next, nr - 1, nc, copy);
            }
        } else {
            if (nr - 1 >= lr) {//우로 이동하는데 범위에 안벗어났으면
                move(lr, lc, rr, rc, dir, next, nr - 1, nc, copy);
            } else { //우로 이동하는데 범위 초과면 아래로 이동한다.
                move(lr, lc, rr, rc, 0, next, nr, nc + 1, copy);
            }
        }
    }
}
