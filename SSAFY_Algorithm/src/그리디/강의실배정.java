package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 강의실배정 {
    static int N;
    static Point[] arr;

    static class Point implements Comparable<Point> {
        int start, end;

        Point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Point o) {
            if (o.start == this.start)
                return this.end - o.end;
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Point(start, end);
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.add(arr[0].end);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].start<que.peek() ) {
                que.add(arr[i].end);
            } else {
                que.poll();
                que.add(arr[i].end);
            }

        }
        System.out.println(que.size());


    }
}
