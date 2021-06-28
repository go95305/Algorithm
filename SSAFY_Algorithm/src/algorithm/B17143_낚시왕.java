package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B17143_낚시왕 {
    static class Point {
        int r, c, spd, dir, size;

        Point(int r, int c, int spd, int dir, int size) {
            this.r = r;
            this.c = c;
            this.spd = spd;
            this.dir = dir;
            this.size = size;
        }
    }

    static int R, C, M;
    static int map[][];
    static List<Point> list;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, 1, -1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            list.add(new Point(r, c, s, d, z));//상어위치 정보 리스트
            map[r][c] = 1;//상어위치
        }
        ans = 0;
        int move = 0;
        while (move < C) {
            searchShark(move);

            moveShark();

            eatShark();
            move++;//사람 오른쪽으로 한칸 이동
        }
        System.out.println(ans);


    }

    private static void eatShark() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 1) {
                    eatSmallShark(i, j);
                }
            }
        }
    }

    private static void eatSmallShark(int r, int c) {
        int size = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).r == r && list.get(i).c == c) {
                if (list.get(i).size > size) {
                    size = list.get(i).size;
                }
            }
        }

        //제일 큰 size가 아니면 전부 지운다.
        List<Integer> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).r == r && list.get(i).c == c) {
                if (list.get(i).size != size) {
                    map[list.get(i).r][list.get(i).c]--;
                    delList.add(i);
                }
            }
        }
        List<Point> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!delList.contains(i))
                newList.add(list.get(i));
        }
        list = newList;
    }

    private static void moveShark() {
        List<Point> newMove = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Point p = list.get(i);
            int r = p.r;
            int c = p.c;
            if (map[r][c] > 0)
                map[r][c]--;
            int dir = p.dir;
            for (int k = 0; k < p.spd; k++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    r = nr;
                    c = nc;
                } else {//벽에 부딪히면 방향 바꾸기
                    int changeR = 0;
                    int changeC = 0;
                    if (dir == 0) {//위엿으면 아래로
                        dir = 1;
                    } else if (dir == 1) {//아래엿으면 위로
                        dir = 0;
                    } else if (dir == 2) {// 오른쪽이엿으면 왼쪽으로
                        dir = 3;
                    } else {//왼쪽이였으면 오른쪽으로
                        dir = 2;
                    }
                    changeR = r + dr[dir];
                    changeC = c + dc[dir];
                    r = changeR;
                    c = changeC;
                }
            }
            newMove.add(new Point(r, c, p.spd, dir, p.size));
            map[r][c]++;
        }
        list = newMove;
    }

    /**
     * 상어 검색
     */
    private static void searchShark(int person) {
        for (int i = 0; i < R; i++) {
            if (map[i][person] == 1) {//해당위치에 상어가 있으면 상어를 배열에서 지우고 리스트에서도 지운다.
                map[i][person] = 0;
                addSharkSize(i, person);
                deleteShark(i, person);
                return;
            }
        }
    }

    private static void addSharkSize(int r, int c) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).r == r && list.get(i).c == c) {
                ans += list.get(i).size;
                return;
            }
        }
    }

    /**
     * 상어 제거
     */
    private static void deleteShark(int r, int c) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).r == r && list.get(i).c == c) {
                list.remove(i);
                return;
            }
        }
    }
}
