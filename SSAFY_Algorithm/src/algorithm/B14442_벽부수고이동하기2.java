package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14442_벽부수고이동하기2 {
    static int N, M, K;
    static int map[][];
    static boolean v[][][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    static class Point {
        int r, c, cnt, turn;

        Point(int r, int c, int cnt, int turn) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.turn = turn;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = str.charAt(j) - '0';
        }
        v = new boolean[K + 1][N][M];
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0, 1, K));
        v[K][0][0] = true;
        int ans = Integer.MAX_VALUE;
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.r == N - 1 && p.c == M - 1) {
                ans = p.cnt;
                break;
            }
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 1) {
                        if (p.turn > 0) {
                            if (!v[p.turn - 1][nr][nc]) {
                                v[p.turn - 1][nr][nc] = true;
                                que.add(new Point(nr, nc, p.cnt + 1, p.turn - 1));
                            }
                        }
                    } else {
                        if (!v[p.turn][nr][nc]) {
                            v[p.turn][nr][nc] = true;
                            que.add(new Point(nr, nc, p.cnt + 1, p.turn));
                        }
                    }
                }
            }
        }
        if (ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

}