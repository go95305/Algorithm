package 그래프탐색;

import sun.security.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16954_움직이는미로탈출 {
    static int N;
    static char map[][];
    static boolean flag;

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int dr[] = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int dc[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean v[][];
    static List<Point> wall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 8;
        map = new char[N][N];

        wall = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '#') {
                    wall.add(new Point(i, j));
                }
            }
        }
        flag = false;
        v = new boolean[N][N];
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(7, 0));


        bfs(que);

        if (flag)
            System.out.println(1);
        else
            System.out.println(0);


    }

    private static void bfs(Queue<Point> que) {
        v[7][0] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.r == 0 && p.c == N - 1) {
                flag = true;
                return;
            }
            for (int k = 0; k < 9; k++) {
                if (k != 8) {
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] == '.') {
                        que.add(new Point(nr, nc));
                        map[nr][nc] = '1';
                        v[nr][nc] = true;
                    }
                } else {
                    que.add(p);
                    v[p.r][p.r] = true;
                }
            }

            System.out.println("========사람 움직이고난후===========");
            System.out.println(que.size() + "   사람 공간 수");
            print();
            if (wall.size() > 0)
                movewall();
            System.out.println(wall.size());
            System.out.println("===========벽 움직이고난 후===========");
            print();
            //벽과 겹치는 사람의 칸을 없앤다.
            deleteStanding(que);
            v = new boolean[N][N];
            setCurVisit();


        }
    }

    private static void setCurVisit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1)
                    v[i][j] = true;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    private static void deleteStanding(Queue<Point> que) {
        int size = que.size();
        for (int i = 0; i < size; i++) {
            Point p = que.poll();
            boolean fl = false;
            for (int j = 0; j < wall.size(); j++) {
                if (p.r == wall.get(j).r && p.c == wall.get(j).c) {
                    fl = true;
                    v[p.r][p.c]=false;
                    break;
                }
            }
            if (!fl) {
                que.add(p);
            }
        }
    }

    private static void movewall() {
        List<Point> tmp = new ArrayList<>();
        char[][] tmpMap = new char[N][N];
        setMap(tmpMap);

        for (int i = 0; i < wall.size(); i++) {
            Point p = wall.get(i);
            int nr = p.r + 1;
            if (nr != N) {
                tmp.add(new Point(nr, p.c));
                tmpMap[nr][p.c] = '#';
            }
        }
        wall = tmp;
        map = tmpMap;
    }

    private static void printC(char[][] tmpMap) {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(tmpMap[i]));
        }
        System.out.println();
    }

    private static void setMap(char[][] tmpMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1')
                    tmpMap[i][j] = '1';
                else
                    tmpMap[i][j] = '.';
            }
        }
        System.out.println("==========copy 지도===========");
        printC(tmpMap);
    }

}
