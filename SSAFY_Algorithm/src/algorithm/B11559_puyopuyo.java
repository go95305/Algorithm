package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B11559_puyopuyo {
    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class newPoint {
        int r, c;
        char color;

        newPoint(int r, int c, char color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char map[][] = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        int ans = 0;
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        while (true) {
            boolean isColor = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.') {
                        boolean v[][] = new boolean[12][6];
                        Queue<Point> que = new LinkedList<>();
                        v[i][j] = true;
                        que.add(new Point(i, j));
                        int cnt = 1; //4개이상 일치하는지 카운트
                        Queue<Point> delQue = new LinkedList<>();
                        delQue.add(new Point(i, j));
                        while (!que.isEmpty()) {
                            Point p = que.poll();
                            for (int k = 0; k < 4; k++) {
                                int nr = p.r + dr[k];
                                int nc = p.c + dc[k];
                                if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6 && map[i][j] == map[nr][nc] && !v[nr][nc]) {
                                    cnt++;
                                    v[nr][nc] = true;
                                    delQue.add(new Point(nr, nc));
                                    que.add(new Point(nr, nc));
                                }
                            }
                        }
                        if (cnt >= 4) {//같은 색이 4개이상 모이면 '.'으로 바꾼다.
                            deletemap(delQue, map);
                            isColor = true;
                            //각 열의 맨 아래부터 위로 탐색
                        }
                    }
                }
            }
            rearrange(map);
            if (!isColor)
                break;
            else
                ans++;
        }
        System.out.println(ans);
    }

    private static void print(char[][] map) {
        for (int i = 0; i < 12; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    private static void rearrange(char[][] map) {
        for (int i = 0; i < 6; i++) {
            int cnt = 0;
            Queue<newPoint> que = new LinkedList<>();
            for (int j = 11; j >= 0; j--) {
                if (map[j][i] != '.') {
                    que.add(new newPoint(j, i, map[j][i]));
                    map[j][i] = '.';
                    cnt++;
                }
            }

            if (cnt > 0) {
                setNewMap(map, que, i, cnt);
            }
        }
    }

    private static void setNewMap(char[][] map, Queue<newPoint> que, int col, int cnt) {
        for (int i = 11; i > 11 - cnt; i--) {
            newPoint p = que.poll();
            map[i][col] = p.color;
        }

    }


    private static void deletemap(Queue<Point> delQue, char map[][]) {
        while (!delQue.isEmpty()) {
            Point p = delQue.poll();
            map[p.r][p.c] = '.';
        }
    }

}
