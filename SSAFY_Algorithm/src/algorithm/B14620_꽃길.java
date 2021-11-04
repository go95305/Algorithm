package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14620_꽃길 {
    static int N;
    static int map[][];
    static ArrayList<Point> list;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int ans;
    static boolean v[][];

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        v = new boolean[N][N];
        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int depth, int sum) {
        if (depth == 3) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isPos(i, j)) {
                    isVisit(i, j, true);
                    int hap = getSum(i, j);
                    dfs(depth + 1, sum + hap);
                    isVisit(i, j, false);
                }
            }
        }
    }

    private static void isVisit(int r, int c, boolean b) {
        v[r][c] = b;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            v[nr][nc] = b;
        }
    }

    private static boolean isPos(int r, int c) {
        if (v[r][c])
            return false;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (!(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]))
                return false;
        }
        return true;
    }

    private static int getSum(int r, int c) {
        int sum = map[r][c];
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            sum += map[nr][nc];
        }
        return sum;
    }


}
