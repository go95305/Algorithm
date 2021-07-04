package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17142_연구소3 {
    static int N, M;
    static int map[][];
    static boolean v[][];
    static int ans;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static boolean[] listChk;
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

        map = new int[N][N];
        int zero = 0;
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zero++;
                }
                if (map[i][j] == 2) {
                    list.add(new Point(i, j));
                }
            }
        }
        listChk = new boolean[list.size()];
        ans = Integer.MAX_VALUE;

        if (zero == 0) {
            System.out.println(0);
        } else {
            combination(0, 0, zero);
            if (ans == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(ans);
        }
    }

    private static void combination(int idx, int k, int zero) {
        if (k == M) {
            bfs(zero);
            return;
        }
        for (int i = idx; i < list.size(); i++) {
            listChk[i] = true;
            combination(i + 1, k + 1, zero);
            listChk[i] = false;
        }
    }

    private static void bfs(int zero) {
        //2인 좌표 전부 0 으로 설정
        int[][] copy = new int[N][];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        setZero(copy);
        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < listChk.length; i++) {
            if (listChk[i])
                que.add(list.get(i));
        }
        int time = 0;
        while (!que.isEmpty()) {

            if (time >= ans)
                return;
            int size = que.size();
            for (int i = 0; i < size; i++) { //현재만 동시확산
                Point p = que.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && (copy[nr][nc] == 0 || copy[nr][nc] == -1)) {
                        if (copy[nr][nc] == 0) {
                            zero--;
                        }
                        copy[nr][nc] = 2;
                        que.add(new Point(nr, nc));
                    }
                }
            }
            time++;
            if (zero == 0) {
                ans = time;
                return;
            }
        }

    }

    private static void setZero(int[][] map) {
        for (int i = 0; i < list.size(); i++) {
            Point p = list.get(i);
            if (!listChk[i])
                map[p.r][p.c] = -1;
        }
    }
}
