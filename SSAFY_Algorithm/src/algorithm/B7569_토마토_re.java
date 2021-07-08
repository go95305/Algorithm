package algorithm;

import javax.sql.rowset.FilteredRowSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569_토마토_re {
    static int M, N, H;
    static int map[][][];
    static boolean v[][][];
    static int dr[] = {-1, 1, 0, 0, 0, 0};
    static int dc[] = {0, 0, -1, 1, 0, 0};
    static int dh[] = {0, 0, 0, 0, 1, -1};//위 아래 그대로 그대로
    static int zero;
    static int day;

    static class Point {
        int r, c, h;

        Point(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        v = new boolean[H][N][M];
        zero = 0;
        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 0)
                        zero++;
                    if (map[i][j][k] == 1) {
                        que.add(new Point(i, j, k));
                        v[i][j][k] = true;
                    }
                }
            }
        }

        if (zero == 0) {
            System.out.println(0);
        } else {
            day = 1;
            bfs(que);
            if (zero > 0)
                System.out.println(-1);
            else
                System.out.println(day);
        }


    }

    private static void bfs(Queue<Point> que) {
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point p = que.poll();
                for (int k = 0; k < 6; k++) {
                    int nh = p.h + dh[k];
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && nh >= 0 && nh < H && !v[nh][nr][nc] && map[nh][nr][nc] == 0) {
                        v[nh][nr][nc] = true;
                        zero--;
                        que.add(new Point(nh, nr, nc));
                    }
                }
            }
            if (zero == 0)
                return;
//            print();
            day++;
        }
    }

    private static void print() {
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (v[h][i][j])
                        System.out.print("o");
                    else
                        System.out.print(".");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
}
