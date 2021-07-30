package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B20058_마법사상어와파이어스톰 {
    static int N, Q;
    static int map[][];
    static int firestorm[];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int tmp[][];
    static boolean v[][];
    static int ans;

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
        Q = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        firestorm = new int[Q];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < Q; i++)
            firestorm[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < firestorm.length; i++) {
            spin(firestorm[i], size);
            melt(size);
        }
        v = new boolean[size][size];
        ans = 0;
        int sum = leftOver(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] > 0 && !v[i][j]) {
                    bfs(i, j, size);
                }
            }
        }
        System.out.println(sum);
        System.out.println(ans);


    }

    private static void bfs(int r, int c, int size) {
        int cnt = 1;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(r, c));
        v[r][c] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < size && nc >= 0 && nc < size && !v[nr][nc] && map[nr][nc] > 0) {
                    v[nr][nc] = true;
                    cnt++;
                    que.add(new Point(nr, nc));
                }
            }
        }
        ans = Math.max(ans, cnt);

    }

    private static void melt(int size) {
        Queue<Point> melt = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] > 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 0 && nr < size && nc >= 0 && nc < size && map[nr][nc] > 0) {
                            cnt++;
                        }
                    }
                    if (cnt < 3) {
                        melt.add(new Point(i, j));
                    }
                }
            }
        }
        while (!melt.isEmpty()) {
            Point p = melt.poll();
            map[p.r][p.c]--;
        }
    }

    private static int leftOver(int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] > 0)
                    sum += map[i][j];
            }
        }
        return sum;
    }

    private static void spin(int l, int size) {
        tmp = new int[size][size];
        int border = (int) Math.pow(2, l);
        for (int i = 0; i < size; i += border) {
            for (int j = 0; j < size; j += border) {
                fire(i, j, border);
            }
        }
    }

    private static void fire(int r, int c, int border) {
        for (int i = 0; i < border; i++) {
            for (int j = 0; j < border; j++) {
                tmp[j][border - 1 - i] = map[i + r][j + c];
            }
        }

        for (int i = 0; i < border; i++) {
            for (int j = 0; j < border; j++) {
                map[r + i][c + j] = tmp[i][j];
            }
        }
    }
}
