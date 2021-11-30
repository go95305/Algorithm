package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17085_십자가2개놓기 {
    static int N, M;
    static char map[][];

    static int size;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

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
        boolean v[][] = new boolean[N][M];
        char copy[][] = new char[N][M];

        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        dfs(0, copy, v);
        System.out.println(size);

    }

    private static void dfs(int depth, char[][] copy, boolean[][] v) {
        if (depth == 2) {
            size = Math.max(size, getSize(copy));
//            System.out.println(size);
//            print(copy);
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
                    if (depth == 0)
                        tmp[i][j] = '1';
                    else
                        tmp[i][j] = '2';
                    vi[i][j] = true;
                    cross(i, j, tmp, vi, depth);

                    dfs(depth + 1, tmp, vi);
                    //십자가를 풀기
                    tmp[i][j] = '#';
                    vi[i][j] = false;
                }
            }
        }
    }

    private static void print(char[][] copy) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(copy[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    private static int getSize(char[][] copy) {
        int size1 = 0;
        int size2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == '1')
                    size1++;
                if (copy[i][j] == '2')
                    size2++;

            }
        }
        return size1 * size2;
    }

    private static void cross(int r, int c, char[][] tmp, boolean[][] vi, int depth) {
        int d = 1;
        while (true) {
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k] * d;
                int nc = c + dc[k] * d;
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || vi[nr][nc] || tmp[nr][nc] != '#') {
                    return;
                }
            }
            setCross(r, c, d, tmp, vi, depth);
            dfs(depth + 1, tmp, vi);
            d++;
        }
    }

    private static void setCross(int r, int c, int dist, char[][] tmp, boolean[][] vi, int depth) {
        for (int j = 1; j <= dist; j++) {
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k] * j;
                int nc = c + dc[k] * j;
                if (depth == 0)
                    tmp[nr][nc] = '1';
                else
                    tmp[nr][nc] = '2';
                vi[nr][nc] = true;
            }
        }
    }
}
