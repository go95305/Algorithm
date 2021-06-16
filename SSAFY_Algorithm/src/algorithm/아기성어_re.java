package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 아기성어_re {
    static int N;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int sharkSize;
    static int sharkEat;
    static int move;
    static int curR, curC;
    static int minCnt;
    static int minIdx;

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
        map = new int[N][N];
        int r = 0, c = 0;
        sharkSize = 2;
        sharkEat = 0;
        move = 0;
        List<Point> eat = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    r = i;
                    c = j;
                }
                if (map[i][j] < 9 && map[i][j] > 0) {
                    eat.add(new Point(i, j, map[i][j]));
                }
            }
        }

        v = new boolean[N][N];
        v[r][c] = true;
        map[r][c] = 0;
        minIdx = 0;
        int ans = 0;
        while (!eat.isEmpty()) {
            minCnt = Integer.MAX_VALUE;
            for (int i = 0; i < eat.size(); i++) { //여기서는 어떤 물고기를 먹었는지 하나 고른다.
                v = new boolean[N][N];
                if (eat.get(i).cnt < sharkSize) {
                    v[r][c] = true;
                    bfs(r, c, eat.get(i).r, eat.get(i).c, i);
                }
            }
            if (minCnt == Integer.MAX_VALUE)
                break;
            r = curR;
            c = curC;
            map[r][c] = 0;
            sharkEat++;
            if (sharkEat == sharkSize) {
                sharkEat = 0;
                sharkSize++;
            }
            ans += move;
            eat.remove(minIdx);

        }
        System.out.println(ans);
    }


    private static List<Point> nextEat() {
        List<Point> que = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] < sharkSize && map[i][j] > 0)
                    que.add(new Point(i, j, 0));
            }
        }
        return que;
    }


    private static void bfs(int x, int y, int r, int c, int idx) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x, y, 0));
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.r == r && p.c == c) { // 목표 물고기에 도달하면
                if (p.cnt == minCnt) {
                    if (p.r < curR) {
                        curR = p.r;
                        curC = p.c;
                        minIdx = idx;
                        move = p.cnt;
                    } else if (p.r == curR) {
                        if (p.c < curC) {
                            curR = p.r;
                            curC = p.c;
                            minIdx = idx;
                            move = p.cnt;
                        }
                    }
                } else if (p.cnt < minCnt) {
                    move = p.cnt;
                    curR = p.r;
                    curC = p.c;
                    minIdx = idx;
                    minCnt = p.cnt;
                }
                return;
            }
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] <= sharkSize) {
                    v[nr][nc] = true;
                    que.add(new Point(nr, nc, p.cnt + 1));
                }
            }
        }
    }
}
