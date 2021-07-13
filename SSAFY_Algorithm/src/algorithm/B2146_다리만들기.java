package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2146_다리만들기 {
    static int N;
    static int map[][];
    static boolean v[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int dist;

    static class Point {
        int cur, r, c, cnt;

        Point(int cur, int r, int c, int cnt) {
            this.cur = cur;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        v = new boolean[N][N];
        int idx = 1;
        /** 연결된곳의 값을 1,2,...이렇게 바꿔준다.*/
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j] && map[i][j] != 0) {
                    v[i][j] = true;
                    setVal(i, j, idx++);
                }
            }
        }
        dist = Integer.MAX_VALUE;

        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j] && map[i][j] != 0) {
                    v[i][j] = true;
                    Bridge(i, j, map[i][j]);
                    //0인곳의 방문 기록 지우기
                    delChk();
                }
            }
        }
        System.out.println(dist);


    }

    private static void delChk() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0)
                    v[i][j] = false;
            }
        }
    }

    private static void Bridge(int r, int c, int value) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(value, r, c, 0));
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.cnt >= dist) {
                break;
            }
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] != p.cur) {
                    if (map[nr][nc] == 0) {
                        v[nr][nc] = true;
                        que.add(new Point(p.cur, nr, nc, p.cnt + 1));
                    } else {
                        dist = Math.min(dist, p.cnt);
                    }
                }
            }
        }
    }

    private static void setVal(int r, int c, int idx) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(idx, r, c, 0));
        map[r][c] = idx;
        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] != 0) {
                    v[nr][nc] = true;
                    map[nr][nc] = idx;
                    que.add(new Point(idx, nr, nc, 0));
                }
            }
        }
    }
}
