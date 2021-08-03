package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B19237_어른상어 {
    static int N, M, k;
    static int map[][];
    static int sharkDir[][][];
    static Point sharkMove[];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int visit[][];
    static boolean sharkMoveChk[];
    static int ans;

    static class Point {
        int r, c, dir, num;

        Point(int r, int c, int dir, int num) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.num = num;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        sharkMove = new Point[M];
        map = new int[N][N];
        sharkMoveChk = new boolean[M];
        visit = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    sharkMove[map[i][j] - 1] = new Point(i, j, 0, map[i][j]);
                    visit[i][j] = k;
                }
            }
        }
        ans = -1;

        /** 상어위치*/
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            Point p = sharkMove[i];
            sharkMove[i] = new Point(p.r, p.c, Integer.parseInt(st.nextToken()) - 1, p.num);
        }

        /** 상어마다 우선순위*/
        sharkDir = new int[M][4][4];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int l = 0; l < 4; l++) {
                    sharkDir[i][j][l] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }
        move();
        System.out.println(ans);
    }

    private static void move() {
        int time = 0;
        while (time < 1000) {
            List<Point> toMove = new ArrayList<>();
            for (int i = 0; i < sharkMove.length; i++) {
                Point p = sharkMove[i];
                if (!sharkMoveChk[p.num - 1]) {
                    boolean flag = false;
                    int dir = p.dir;
                    for (int d = 0; d < 4; d++) {//냄새가 없는 곳 4방탐색
                        int nr = p.r + dr[sharkDir[p.num - 1][dir][d]];
                        int nc = p.c + dc[sharkDir[p.num - 1][dir][d]];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                            if (map[nr][nc] == 0 && visit[nr][nc] == 0) {
                                flag = true;
                                toMove.add(new Point(nr, nc, sharkDir[p.num - 1][dir][d], p.num));
                                break;
                            }
                        }
                    }

                    if (!flag) {//이동할 곳을 못찾았으면 이미 방문하고 냄새가 나는 내 위치로 이동
                        for (int d = 0; d < 4; d++) {//냄새가 없는 곳 4방탐색
                            int nr = p.r + dr[sharkDir[p.num - 1][dir][d]];
                            int nc = p.c + dc[sharkDir[p.num - 1][dir][d]];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                if (map[nr][nc] == p.num) {
                                    toMove.add(new Point(nr, nc, sharkDir[p.num - 1][dir][d], p.num));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            /** 냄새 -1 부터 하기*/
            minusSmell();

            /** 상어이동하기 */
            moveShark(toMove);
            if (isOnlyLeft()) {
                ans = time + 1;
                break;
            }
            time++;
        }
    }

    private static boolean isOnlyLeft() {
        int cnt = 0;
        for (int i = 0; i < sharkMove.length; i++) {
            Point p = sharkMove[i];
            if (!sharkMoveChk[p.num - 1]) {
                cnt += p.num;
            }
        }
        if (cnt == 1)
            return true;
        return false;
    }

    private static void moveShark(List<Point> toMove) {
        for (int i = 0; i < toMove.size(); i++) {
            Point p = toMove.get(i);
            if (map[p.r][p.c] == 0 || map[p.r][p.c] == p.num) {//상어가 이동할 위치에 이미 다른 상어가 있으면 상어 number를 비교하여 더 작은 숫자가 들어간다. 번호 크기대로 이동하므로 이미 존재한다면 자신보다 작은 숫자이다.
                map[p.r][p.c] = p.num;
                visit[p.r][p.c] = k;
                sharkMove[p.num - 1] = p;
            } else if (map[p.r][p.c] != 0) {
                sharkMoveChk[p.num - 1] = true;
            }
        }
    }

    private static void minusSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] > 0) {
                    visit[i][j]--;
                    if (visit[i][j] == 0) {
                        map[i][j] = 0;
                    }
                }
            }
        }
    }
}
