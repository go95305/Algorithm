package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 창고다각형 {
    static int N;

    static class Point implements Comparable<Point> {
        int r, h;

        Point(int r, int h) {
            this.r = r;
            this.h = h;
        }

        @Override
        public int compareTo(Point o) {
            return this.r - o.r;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", h=" + h +
                    '}';
        }
    }

    static int map[][];
    static List<Point> list;
    static int minr, maxr;
    static int minh, maxh;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        minr = Integer.MAX_VALUE;
        maxr = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()) ;
            int H = Integer.parseInt(st.nextToken()) ;
            if (L < minr) {
                minr = L;
            }
            if (L > maxr) {
                maxr = L;
            }
            if (H < minh)
                minh = H;
            if (H > maxh)
                maxh = H;
            list.add(new Point(L, H));
        }
        map = new int[maxr + 1][maxh];

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            Point p = list.get(i);

            for (int j=0;j<p.h;j++)
                map[p.r][j]=1;
        }
//        System.out.println(list);

        for (int j = 0; j < list.get(list.size() - 1).h; j++) {
            map[maxr][j] = 1;
        }
//        maxr++;

        for (int i = 0; i < list.size(); i++) {
            Point p = list.get(i);
            int idx = i + 1;


            //right
            while (idx < list.size()) {
                if (p.h > list.get(idx).h)
                    idx++;
                else {
//                    System.out.println("right" + i + " " + idx);
                    setMap(p, list.get(idx), 1);
                    break;
                }
                if (idx == list.size())
                    break;
            }


            //left
            idx = i - 1;
            while (idx > 0) {
                if (p.h < list.get(idx).h) {

//                    System.out.println("left" + i + " " + idx);

                    setMap(p, list.get(idx), 2);
                    break;
                } else {
                    idx--;
                }
                if (idx < 0)
                    break;
            }
        }

//        for (int i = 0; i < map.length; i++)
//            System.out.println(Arrays.toString(map[i]));
        int cnt=0;
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[i].length;j++){
                if (map[i][j]==1)
                    cnt++;
            }
        }
        System.out.println(cnt);


    }

    private static void setMap(Point p1, Point p2, int side) {
        //오른쪽 채우기
        if (side == 1) {
            for (int i = p1.r; i < p2.r; i++) {
                for (int j = 0; j < p1.h; j++) {
                    map[i][j] = 1;
                }
            }
        } else {
            for (int i = p1.r; i > p2.r; i--) {
                for (int j = 0; j < p1.h; j++) {
                    map[i][j] = 1;
                }
            }
        }
    }
}
