package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2636_치즈 {
    static int N, M;
    static int map[][];

    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int all;
    static List<Point> list;

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    all++;
            }
        }

        int cnt = 0;
        int ans = all;
        while (true) {
            cnt++;
            boolean side[][] = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        edge(i, j, side);
                    }
                }
            }

            removeEdge(side);

            if (all == 0) {
                break;
            }
            ans = all;

        }

        System.out.println(cnt);
        System.out.println(ans);


    }

    private static void print() {
        for (int i = 0; i < N; i++)
            System.out.println(Arrays.toString(map[i]));
        System.out.println();
    }

    private static void removeEdge(boolean[][] side) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (side[i][j]) {
                    map[i][j] = 0;
                    all--;
                }
            }
        }
    }

    private static int edgeChk(boolean[][] side) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (side[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void edge(int r, int c, boolean[][] side) {
        boolean v[][] = new boolean[N][M];
        Queue<Point> que = new LinkedList<>();
        v[r][c] = true;
        que.add(new Point(r, c));
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.r == N - 1 || p.c == M - 1) {
                side[r][c] = true;
                break;
            }
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 0) {
                    v[nr][nc] = true;
                    que.add(new Point(nr, nc));
                }
            }
        }
    }


}
