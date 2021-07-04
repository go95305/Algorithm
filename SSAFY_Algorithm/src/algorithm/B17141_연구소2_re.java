package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17141_연구소2_re {
    static int N, M;
    static int map[][];
    static boolean v[][];
    static int ans;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static boolean listChk[];
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
        zero += list.size() - M;
        if (zero == 0) {
            System.out.println(0);
        } else {
            combination(0, 0, zero);
        }
        System.out.println(ans);
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
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && copy[nr][nc] == 0) {
                        copy[nr][nc] = 2;
                        zero--;
                        System.out.println(zero);
                        print(copy);
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

    private static void print(int[][] copy) {
        for (int i=0;i<copy.length;i++){
            System.out.println(Arrays.toString(copy[i]));
        }
        System.out.println();
    }

    private static void setZero(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2)
                    map[i][j] = 0;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (listChk[i]) {
                Point p = list.get(i);
                map[p.r][p.c] = -1;
            }
        }
    }
}
