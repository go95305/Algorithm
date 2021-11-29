package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17085_십자가2개놓기 {
    static int N, M;
    static char map[][];
    static boolean v[][];
    static int size;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

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
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        size = 0;
        v = new boolean[N][M];
        char copy[][] = new char[N][M];
        dfs(0, copy);
        System.out.println(size);

    }

    private static void dfs(int depth, char[][] copy) {
        if (depth == 2) {
            size = Math.max(size, getSize());
            print();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '#' && !v[i][j]) {
                    char[][] tmp = new char[N][M];
                    boolean vi[][] = new boolean[N][M];
                    for (int k = 0; k < N; k++) {
                        tmp[k] = copy[k].clone();
                        vi[k] = v[k].clone();
                    }
                    cross(i, j, tmp, vi);

                    dfs(depth + 1, copy);
                    //십자가를 풀기

                    dCross(i, j, d);
                    print();
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void dCross(int r, int c, int d) {
        map[r][c] = '#';

        for (int j = 1; j <= d; j++) {
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k] * j;
                int nc = c + dc[k] * j;
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    map[nr][nc] = '#';
                    v[nr][nc] = false;
                }
            }
        }
    }

    private static int getSize() {
        int size = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*')
                    size++;
            }
        }
        return size;
    }

    private static void cross(int r, int c, char[][] tmp, boolean[][] vi) {
        map[r][c] = '*';
        while (true) {
            int d = 1;
            char[][] copy = new char[N][M];
            boolean vv[][] = new boolean[N][M];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k] * d;
                int nc = c + dc[k] * d;
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !vi[nr][nc] && tmp[nr][nc] == '#') {
                    copy[nr][nc] = '*';
                    vv[nr][nc] = true;
                } else {
                    return;
                }
            }
            vi = vv;
            tmp = copy;
            d++;
        }
    }
}
