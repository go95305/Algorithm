package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B14502_연구소 {
    static int N, M;
    static int map[][];
    static int copyMap[][];
    static ArrayList<Point> list;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int Ans;

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
        copyMap = new int[N][M];
        Ans = 0;
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    list.add(new Point(i, j));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        mapWall(0);
        System.out.println(Ans);

    }

    private static void mapWall(int depth) {
        if (depth == 3) {
            countSafe();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    copyMap[i][j] = 1;
                    mapWall(depth + 1);
                    copyMap[i][j]=0;
                }
            }
        }
    }

    private static void countSafe() {

        int useMap[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                useMap[i][j] = copyMap[i][j];
            }
        }

        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            que.add(new Point(list.get(i).r, list.get(i).c));
        }

        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && useMap[nr][nc] == 0) {
                    useMap[nr][nc] = 2;
                    que.add(new Point(nr, nc));
                }
            }
        }

        Ans = Math.max(count(useMap), Ans);

    }

    private static int count(int[][] useMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (useMap[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }
}
