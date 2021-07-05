package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055_탈출 {
    static int R, C;
    static char[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans;
    static boolean flag;
    static Queue<Point> queW, queS;

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        queS = new LinkedList<>();
        queW = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    queS.add(new Point(i, j));
                }
                if (map[i][j] == '*') {
                    queW.add(new Point(i, j));
                }
            }
        }
        ans = 0;
        flag = false;
        bfs();
        if (!flag) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(ans);
        }
    }


    private static void bfs() {

        while (true) {
            int size = queW.size();
            for (int i = 0; i < size; i++) {
                Point p = queW.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && (map[nr][nc] == 'S' || map[nr][nc] == '.')) {
                        map[nr][nc] = '*';
                        queW.add(new Point(nr, nc));
                    }
                }
            }

            size = queS.size();
            for (int i = 0; i < size; i++) {
                Point p = queS.poll();
                if (map[p.r][p.c] == 'D') {
                    flag = true;
                    return;
                }
                for (int k = 0; k < 4; k++) {
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {
                        if (map[nr][nc] != 'D') {
                            map[nr][nc] = 'S';
                        }
                        queS.add(new Point(nr, nc));
                    }
                }

            }
            if (flag || queS.isEmpty()) {
                return;
            }
            ans++;
        }
    }
}