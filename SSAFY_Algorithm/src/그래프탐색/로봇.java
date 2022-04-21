package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇 {
    static int N, M;
    static int map[][];
    static int dr[] = {0, 0, 1, -1};//서북동남
    static int dc[] = {1, -1, 0, 0};
    static int pr, pc, pdir;
    static boolean v[][][];
    static int ans;

    static class Point {
        int r, c, dir, cnt;

        Point(int r, int c, int dir, int cnt) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M + 1][N + 1];
        v = new boolean[1000][M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        pr = Integer.parseInt(st.nextToken());
        pc = Integer.parseInt(st.nextToken());
        pdir = Integer.parseInt(st.nextToken());

        Queue<Point> que = new LinkedList<>();
        que.add(new Point(sr, sc, dir, 0));
        v[dir][sr][sc] = true;
        bfs(que);

    }

    private static void bfs(Queue<Point> que) {
        while (!que.isEmpty()) {
            //모든 방향만 설정하고 다시 넣는다.
            Point p = que.poll();
            if (p.r == pr && p.c == pc && pdir == p.dir) {
                System.out.println(p.cnt);
                return;
            }


            for (int k = 1; k <= 3; k++) {
                int nr = p.r + dr[p.dir - 1] * k;
                int nc = p.c + dc[p.dir - 1] * k;
                if (nr > 0 && nr <= M && nc > 0 && nc <= N) {
                    if (map[nr][nc] == 0) {
                        if (!v[p.dir][nr][nc]) {
                            v[p.dir][nr][nc] = true;
                            que.add(new Point(nr, nc, p.dir, p.cnt + 1));
                        }
                    } else
                        break;
                }
            }



        for (int i = 1; i <= 4; i++) {
            if (p.dir != i && !v[i][p.r][p.c]) {
                int turn = 1;
                if (p.dir == 1) {
                    if (i == 2) {
                        turn++;
                    }
                } else if (p.dir == 2) {
                    if (i == 1) {
                        turn++;
                    }
                } else if (p.dir == 3) {
                    if (i == 4) {
                        turn++;
                    }
                } else {
                    if (i == 3) {
                        turn++;
                    }
                }
                v[i][p.r][p.c] = true;
                que.add(new Point(p.r, p.c, i, p.cnt + turn));
            }
        }
    }

}
}
