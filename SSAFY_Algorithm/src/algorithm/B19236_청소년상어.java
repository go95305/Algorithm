package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B19236_청소년상어 {
    static int map[][];
    static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dc[] = {0, -1, -1, -1, 0, 1, 1, 1};
    static int ans;
    static boolean v[];
    static Point fish[];

    static class Point {
        int r, c, value, dir;

        Point(int r, int c, int value, int dir) {
            this.r = r;
            this.c = c;
            this.value = value;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[4][4];
        fish = new Point[17];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                int dir = Integer.parseInt(st.nextToken()) - 1;
                fish[num] = new Point(i, j, num, dir);
            }
        }
        v = new boolean[17];
        //0,0은 상어가 먹고 시작
        ans = 0;
        v[map[0][0]] = true;
        int eaten = map[0][0];
        int sharkDir = fish[map[0][0]].dir;
        map[0][0] = -1;//상어 위치
        int[][] copy = new int[4][];
        for (int k = 0; k < 4; k++) {
            copy[k] = map[k].clone();
        }
        Point[] copyFish = fish.clone();
        goFish(0, 0, sharkDir, eaten, copy, copyFish);
        System.out.println(ans);
//        print();
    }

    private static void goFish(int sharkR, int sharkC, int sharkDir, int eaten, int[][] map, Point[] fish) {
        ans = Math.max(ans, eaten);
        moveFish(map, fish);
        eatFish(sharkR, sharkC, sharkDir, eaten, map, fish);
    }

    private static void eatFish(int sharkR, int sharkC, int sharkDir, int eaten, int[][] map, Point[] fish) {
        int dir = sharkDir;
        for (int j = 1; j <= 4; j++) {
            int nr = sharkR + dr[dir] * j;
            int nc = sharkC + dc[dir] * j;
            if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && map[nr][nc] != 0 && !v[map[nr][nc]]) {
                int[][] copy = new int[4][];
                for (int k = 0; k < 4; k++) {
                    copy[k] = map[k].clone();
                }
                Point[] copyFish = fish.clone();
                v[copy[nr][nc]] = true; //물고기 먹기 체크 15
                int newDir = copyFish[copy[nr][nc]].dir;// 물고기의 방향 2
                copy[sharkR][sharkC] = 0; //현재 위치는 0으로 빈칸 표시 0,0
                int size = copy[nr][nc];//15
                copy[nr][nc] = -1;//새로운 위치 -1

                goFish(nr, nc, newDir, eaten + size, copy, copyFish);
                copy[nr][nc] = size;
                v[copy[nr][nc]] = false;
                copy[sharkR][sharkC] = -1;
            }
        }
        dir++;
        if (dir == 8)
            dir = 0;

    }

    //movefish 에러 여기서 다시 보자
    private static void moveFish(int[][] map, Point[] fish) {
        for (int i = 1; i < fish.length; i++) {
            if (!v[i]) {//상어한테 먹힌 물고기가 아니면
                Point p = fish[i];
                int dir = p.dir;
                for (int k = 0; k < 8; k++) {
                    int nr = p.r + dr[dir];
                    int nc = p.c + dc[dir];
                    if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && map[nr][nc] != -1) {
                        if (map[nr][nc] == 0) {//빈칸이면
                            map[nr][nc] = p.value;
                            map[p.r][p.c] = 0;
                        } else {//다른 물고기가 있으면
                            int tmp = map[nr][nc];// 15
                            map[nr][nc] = map[p.r][p.c];//1
                            map[p.r][p.c] = tmp;//15
                            fish[tmp] = new Point(p.r, p.c, map[p.r][p.c], fish[tmp].dir);
                        }
                        fish[i] = new Point(nr, nc, p.value, dir);
                        break;
                    }


                    dir++;
                    if (dir == 8) {
                        dir = 0;
                    }
                }
            }
        }
    }
}
