package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 두스티커 {
    static int H, W, N;
    static Point sel[];
    static int ans;
    static boolean v[][];

    static class Point {
        int idx, r, c, size;

        Point(int idx, int r, int c, int size) {
            this.idx = idx;
            this.r = r;
            this.c = c;
            this.size = size;
        }

    }

    static List<Point> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Point(i, r, c, r * c));
            if (r != c)
                list.add(new Point(i, c, r, r * c));
        }
        sel = new Point[2];
        ans = 0;
        combination(0, 0);
        System.out.println(ans);
    }

    private static void combination(int idx, int k) {
        if (k == 2) {
            if (sel[0].idx == sel[1].idx)
                return;

            if (sel[0].r + sel[1].r <= W) {
                if (Math.max(sel[0].c, sel[1].c) <= H) {
                    ans = Math.max(ans, (sel[0].size + sel[1].size));
                }
            }

            if (sel[0].c + sel[1].c <= H) {
                if (Math.max(sel[0].r, sel[1].r) <= W) {
                    ans = Math.max(ans, (sel[0].size + sel[1].size));
                }
            }
            return;
        }

        for (int i = idx; i < list.size(); i++) {
            sel[k] = list.get(i);
            combination(idx + 1, k + 1);
        }
    }
}
