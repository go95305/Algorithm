package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직사각형탈출 {
    static int N, M;
    static int map[][];
    static int H, W;
    static boolean v[][];
    static int tr, tc;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int ans;

    static class Point {
        int r, c, cnt;

        Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(r, c, 0));
        v[r][c] = true;
        tr = Integer.parseInt(st.nextToken()) - 1;
        tc = Integer.parseInt(st.nextToken()) - 1;
        ans = -1;
        bfs(que);
        System.out.println(ans);


    }

    private static void bfs(Queue<Point> que) {
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.r == tr && p.c == tc) {
                ans = p.cnt;
                return;
            }
            for (int k = 0; k < 4; k++) {
                //새로운 왼쪽 위
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && isClear(nr, nc)) {// 새로운 왼쪽위의 좌표기준으로 H,W넓이만큼 0으로만 채워져있는지 검증
                    v[nr][nc] = true;
                    que.add(new Point(nr, nc, p.cnt + 1));
                }
            }
        }
    }

    private static boolean isClear(int r, int c) {
        for (int i = r; i < r + H; i++) {
            for (int j = c; j < c + W; j++) {
                if (i < 0 || i >= N || j < 0 || j >= M)
                    return false;
                else {
                    if (map[i][j] != 0)
                        return false;
                }
            }
        }
        return true;
    }
}
