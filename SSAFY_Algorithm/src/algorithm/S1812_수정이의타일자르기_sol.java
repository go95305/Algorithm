package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S1812_수정이의타일자르기_sol {
    static class Rectangle implements Comparable<Rectangle> {
        int max, min;

        public Rectangle(int width, int height) {
            min = Math.min(width, height);
            max = Math.max(width, height);
        }

        @Override
        public int compareTo(Rectangle o) {
            return o.min - this.min;
        }
    }

    static int N, M, size[], cnt;
    static PriorityQueue<Rectangle> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader((new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            size = new int[N];
            cnt = 0;

            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N; i++) {
                size[i] = Integer.parseInt(st.nextToken());
            }
            cut();
            System.out.println("#"+t+" "+cnt);

        }
    }

    private static void cut() {
        // 만들고자 하는 크기가 큰 타일부터 처리
        Arrays.sort(size);
        queue = new PriorityQueue<Rectangle>();
        queue.offer(new Rectangle(M, M)); // 타일 1장 사고 시작
        ++cnt; // 타일 갯수 증가

        for (int i = N - 1; i >= 0; i--) {
            go(1 << size[i]);
        }
    }

    private static void go(int size) {
        // 자투리 타일중에 min 변의 크기가 최대인 거 꺼내서 비교
        Rectangle r = queue.poll();
        //원하는 크기의 타일을 만들수 있다면 만들고 잘라낸 2개의 자투리 타일을 다시 보관
        if (r.min >= size) {
            queue.offer(new Rectangle(r.min - size, size));
            queue.offer(new Rectangle(r.min, r.max - size));
        } else {
            // 원하는 크기의 타일을 만들수 없다면 새로 타일을 구매해서 잘라내고
            //                            잘라낸 2개의 자투리 타일을 다시 보관관
            //                            꺼내고 사용하지 않은 타일 다시 보관
            ++cnt;
            queue.offer(r);
            queue.offer(new Rectangle(M - size, size));
            queue.offer(new Rectangle(M - size, M));

        }
    }
}
