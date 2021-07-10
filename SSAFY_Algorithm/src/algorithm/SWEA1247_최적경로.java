package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1247_최적경로 {
    static int N;
    static boolean v[];
    static Point work, home;
    static List<Point> list;
    static int ans;

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            work = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.add(new Point(r, c));
            }
            v = new boolean[list.size()];
            ans = Integer.MAX_VALUE;
            permutation(0, 0, 0, work.r, work.c);
            System.out.printf("#%d %d\n",tc,ans);
        }
    }

    private static void permutation(int idx, int k, int size, int beforeR, int beforeC) {
        if (k == list.size()) {
            ans = Math.min(ans, size + Math.abs(beforeR - home.r) + Math.abs(beforeC - home.c));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!v[i]) {
                v[i] = true;
                permutation(i + 1, k + 1, size + Math.abs(beforeR - list.get(i).r) + Math.abs(beforeC - list.get(i).c), list.get(i).r, list.get(i).c);
                v[i] = false;
            }
        }
    }
}
