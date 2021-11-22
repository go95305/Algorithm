package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21610_마법사상어와비바라기 {
    static int map[][];
    static int N, M;
    static int dr[] = {0, -1, -1, -1, 0, 1, 1, 1};
    static int dc[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int rr[] = {-1, -1, 1, 1};
    static int rc[] = {-1, 1, -1, 1};
    static boolean v[][];

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
        map = new int[N][N];
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*초기 구름위치설정*/
        v[N - 1][0] = true;
        v[N - 1][1] = true;
        v[N - 2][0] = true;
        v[N - 2][1] = true;


        int turn = 0;
        while (turn < M) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken()) - 1;
            int i = Integer.parseInt(st.nextToken());
//            System.out.println(d+ " "+i);
            Queue<Point> que = new LinkedList<>();
            que = getCloud();
            moveCloud(d, i, que);

            pour();
            que = getCloud();
            getmoreWater(que);


            newCloud();

            turn++;
        }
        System.out.println(getAllWater());

    }

    private static int getAllWater() {
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                cnt += map[i][j];
            }

        return cnt;
    }

    private static void printw() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    private static void pour() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (v[i][j]) {
                    map[i][j]++;
                }
            }
        }
    }

    private static void newCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) {
                    if (map[i][j] >= 2) {
                        v[i][j] = true;
                        map[i][j] -= 2;
                    }
                } else if (v[i][j]) {
                    v[i][j] = false;
                }
            }
        }
    }

    private static void getmoreWater(Queue<Point> que) {
        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int k = 0; k < 4; k++) {
                int nr = p.r + rr[k];
                int nc = p.c + rc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > 0) {
                    map[p.r][p.c]++;
                }
            }
        }
    }

    private static Queue<Point> getCloud() {
        Queue<Point> tmp = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (v[i][j]) {
                    tmp.add(new Point(i, j));
                }
            }
        }
        return tmp;
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(v[i]));
        }

    }

    private static void moveCloud(int d, int idx, Queue<Point> que) {
        boolean tmpv[][] = new boolean[N][N];
        while (!que.isEmpty()) {
            Point p = que.poll();
            int curx = p.r;
            int cury = p.c;
            for (int k = 0; k < idx; k++) {
                int nr = curx + dr[d];
                int nc = cury + dc[d];
                if (nr == -1) {
                    nr = N - 1;
                }
                if (nr == N) {
                    nr = 0;
                }
                if (nc == -1) {
                    nc = N - 1;
                }
                if (nc == N) {
                    nc = 0;
                }

                curx = nr;
                cury = nc;
            }
            tmpv[curx][cury] = true;
        }
        v = tmpv;

    }
}
