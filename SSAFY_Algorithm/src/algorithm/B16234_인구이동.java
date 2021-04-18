package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16234_인구이동 {
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
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        while (true) {
            boolean v[][] = new boolean[N][N];
            int flag = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!v[i][j]) {
                        Queue<Point> que = new LinkedList<>();
                        Queue<Point> wall = new LinkedList<>();
                        que.add(new Point(i, j));
                        v[i][j] = true;
                        wall.add(new Point(i, j));
                        int total = 1;
                        int sum = 0;
                        while (!que.isEmpty()) {
                            Point p = que.poll();
                            sum += map[p.r][p.c];
                            for (int k = 0; k < 4; k++) {
                                int nr = p.r + dr[k];
                                int nc = p.c + dc[k];
                                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && Math.abs(map[nr][nc] - map[p.r][p.c]) >= L && Math.abs(map[nr][nc] - map[p.r][p.c]) <= R) {
                                    v[nr][nc] = true;
                                    total++;
                                    wall.add(new Point(nr, nc));
                                    que.add(new Point(nr, nc));
                                }
                            }
                        }

                        //새로운 값으로 치환
                        if (total > 1) {
                            flag++;
                            int newNum = sum / total;
                            setNewNum(map, wall, newNum);
                        } else {
                            v[i][j] = false;
                        }

                    }
                }
            }
            if (flag > 0)
                ans++;
            else
                break;
        }
        System.out.println(ans);
    }

    private static void setNewNum(int[][] map, Queue<Point> wall, int newNum) {
        while (!wall.isEmpty()) {
            Point p = wall.poll();
            map[p.r][p.c] = newNum;
        }
    }
}
