package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S3349_최솟값으로이동하기 {
    static int W, H, N;
    static ArrayList<Point> list;

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int stx = 0, sty = 0;
            list = new ArrayList<Point>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new Point(x, y));
            }
            int ans = 0;
            for (int i = 1; i < list.size(); i++) {
                Point n1 = list.get(i - 1);
                Point n2 = list.get(i);

                int x_Cross = (n2.r - n1.r);
                int y_Cross = (n2.c - n1.c);
                if (x_Cross * y_Cross > 0) {
                    if (Math.abs(x_Cross) > Math.abs(y_Cross)) {
                        ans += Math.abs(y_Cross) + (Math.abs(x_Cross) - Math.abs(y_Cross));
                    } else {
                        ans += Math.abs(x_Cross) + (Math.abs(y_Cross) - Math.abs(x_Cross));
                    }
                } else {
                    ans += Math.abs(n2.r - n1.r) + Math.abs(n2.c - n1.c);
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }


}
