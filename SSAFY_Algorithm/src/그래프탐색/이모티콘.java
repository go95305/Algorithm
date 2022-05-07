package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 이모티콘 {
    static boolean v[][];

    static class Point {
        int screen, clip, cnt;

        Point(int screen, int clip, int cnt) {
            this.screen = screen;
            this.clip = clip;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "screen=" + screen +
                    ", clip=" + clip +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int screen = 1;
        int clip = 0;
        v = new boolean[1001][1001];
        bfs(N);
    }

    private static void bfs(int N) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(1, 0, 0));
        v[1][0] = true;
        while (!que.isEmpty()) {

            Point p = que.poll();
//            System.out.println(p);
            if (p.screen == N) {
                System.out.println(p.cnt);
                System.exit(0);
            }
            if (p.screen > 0 && !v[p.screen][p.screen]) {
                v[p.screen][p.screen] = true;
                que.add(new Point(p.screen, p.screen, p.cnt + 1)); // 화면을 클립보드로 덮어쓰기
            }
            if (p.clip > 0 && p.screen + p.clip < 1001 && !v[p.screen + p.clip][p.clip]) {
                v[p.screen + p.clip][p.clip] = true;
                que.add(new Point(p.screen + p.clip, p.clip, p.cnt + 1)); //클립보드를 화면으로 붙여넣기
            }
            if (p.screen > 0 && !v[p.screen - 1][p.clip]) {
                v[p.screen - 1][p.clip] = true;
                que.add(new Point(p.screen - 1, p.clip, p.cnt + 1));
            }
        }

    }
}
