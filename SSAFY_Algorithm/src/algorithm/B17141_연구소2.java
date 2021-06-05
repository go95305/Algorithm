package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17141_연구소2 {
    static int N, M;
    static int map[][];
    static List<Point> list;
    static boolean chk[];
    static int ans;
    static int copy[][];
    static boolean v[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int cnt;

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
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    list.add(new Point(i, j));
                }
                if (map[i][j] == 0)
                    cnt++;
            }
        }
        cnt += list.size() - M;
        ans = Integer.MAX_VALUE;
        if (cnt == 0) {
            ans = 0;
            System.out.println(ans);
        } else {
            chk = new boolean[list.size()];

            combination(0, 0);

            if (ans == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(ans);
        }

    }

    private static void combination(int idx, int k) {
        if (k == M) {
            setQueue();
            return;
        }


        for (int i = idx; i < list.size(); i++) {
            chk[i] = true;
            combination(i + 1, k + 1);
            chk[i] = false;
        }
    }

    private static void setQueue() {
        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (chk[i])
                que.add(list.get(i));
        }

        //BFS시작
        bfs(que, cnt);

    }

    private static void bfs(Queue<Point> que, int cnt) {
        copyMap();

        int time = 0;
        while (!que.isEmpty()) {
            if (ans <= time)
                break;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point p = que.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && copy[nr][nc] == 0) {
                        copy[nr][nc] = 2;
                        que.add(new Point(nr, nc));
                        cnt--;
                    }
                }
            }
            time++;
            if (cnt == 0) {
                ans = time;
                return;
            }
        }

    }

    private static void copyMap() {
        copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2)
                    copy[i][j] = 0;
                else
                    copy[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (chk[i]) {
                int r = list.get(i).r;
                int c = list.get(i).c;
                copy[r][c] = 2;
            }
        }
    }
}
