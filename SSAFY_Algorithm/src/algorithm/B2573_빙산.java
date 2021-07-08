package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2573_빙산 {
    static int N, M;
    static int map[][];
    static boolean v[][];
    static int cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int cross;

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
        Queue<Point> que = new LinkedList<>();
        cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    que.add(new Point(i, j));
                    cnt++;
                }
            }
        }
        int time = 1;
        boolean flag = true;
        while (true) {
            v = new boolean[N][M];
            cross = 0;
            //녹이기
            bfs(que);

            if (que.size() == 0) {//분리전에 다 녹아버렸으므로 실패!
                flag = false;
                break;
            } else {
                //섬 분리확인
                dfs(que.peek().r, que.peek().c);
                if (cnt != cross) {//분리되었으면
                    break;
                }
            }
            time++;
        }
        if (!flag)
            System.out.println(0);
        else
            System.out.println(time);


    }

    private static void dfs(int r, int c) {
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] != 0) {
                v[nr][nc] = true;
                cross++;
                dfs(nr, nc);
            }
        }
    }

    private static void bfs(Queue<Point> que) {
        int copy[][] = new int[N][];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        int size = que.size();
        for (int i = 0; i < size; i++) {
            int melt = 0;
            Point p = que.poll();
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                    melt++;
                }
            }
            copy[p.r][p.c] -= melt;
            if (copy[p.r][p.c] <= 0) {
                cnt--;
                copy[p.r][p.c] = 0;
            } else {
                que.add(p);
            }
        }
        map = copy;
    }
}