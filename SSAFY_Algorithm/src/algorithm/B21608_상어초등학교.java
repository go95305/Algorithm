package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B21608_상어초등학교 {
    static int N;
    static int map[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

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
        map = new int[N][N];

        int cnt = 0;
        List<Integer>[] list = new ArrayList[N * N];
        for (int i = 0; i < N * N; i++) {
            list[i] = new ArrayList<>();
        }
        while (cnt < (N * N)) {
            st = new StringTokenizer(br.readLine(), " ");
            int stNum = Integer.parseInt(st.nextToken()); // 학생 숫자
            for (int i = 0; i < 4; i++) { // 선호하는 학생 4명 숫자 담기
                list[stNum - 1].add(Integer.parseInt(st.nextToken()));
            }

            List<Point> emptyRoom = searchEmpty();// 1조건의 비어있는 칸을 구한다.

            //1 조건의 비어있는 칸 중에서 내가 선호하는 번호가 많은 좌표를 담는다.
            List<Point> like = searchLike(emptyRoom, list[stNum - 1]);


            List<Point> sideRoom = new ArrayList<>();
            if (like.size() > 1) {
                sideRoom = sideEmptyroom(like);
                if (sideRoom.size() > 1) {//인근에 빈칸의 개수가 같은 좌표가 여러개면
                    rowCol(sideRoom, stNum);
                } else { //인근에 빈칸의 개수가 같은 좌표가 하나면®
                    Point p = sideRoom.get(0);
                    map[p.r][p.c] = stNum;
                }
            } else {
                Point p = like.get(0);
                map[p.r][p.c] = stNum;
            }
            cnt++;
        }

        int ans = favor(list);
        System.out.println(ans);

    }

    private static int favor(List<Integer>[] list) {
        int favor = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = map[i][j];
                int likeCnt = 0;
                likeCnt = like(i, j, list[num - 1]);
                if (likeCnt == 0)
                    favor += 0;
                else if (likeCnt == 1)
                    favor += 1;
                else if (likeCnt == 2)
                    favor += 10;
                else if (likeCnt == 3)
                    favor += 100;
                else
                    favor += 1000;
            }
        }
        return favor;
    }

    private static int like(int r, int c, List<Integer> list) {
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (list.contains(map[nr][nc]))
                    cnt++;
            }
        }
        return cnt;
    }

    private static List<Point> searchLike(List<Point> room, List<Integer> like) {
        List<Point> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < room.size(); i++) {
            Point p = room.get(i);
            int cnt = 0;
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (like.contains(map[nr][nc]))
                        cnt++;
                }
            }
            if (max < cnt) {
                list.clear();
                list.add(new Point(p.r, p.c));
                max = cnt;
            } else if (max == cnt) {
                list.add(new Point(p.r, p.c));
            }

        }

        return list;

    }

    private static void rowCol(List<Point> sideRoom, int stNum) {
        int r, c;
        r = Integer.MAX_VALUE;
        c = Integer.MAX_VALUE;
        for (int i = 0; i < sideRoom.size(); i++) {
            Point p = sideRoom.get(i);
            if (r == p.r) {//행이 같을 때
                if (c > p.c) { // 열이 같을 때
                    r = p.r;
                    c = p.c;
                }
            } else if (r > p.r) {
                r = p.r;
                c = p.c;
            }
        }

        map[r][c] = stNum;
    }

    private static List<Point> sideEmptyroom(List<Point> room) {
        int max = 0;
        List<Point> sideRoom = new ArrayList<>();
        for (int i = 0; i < room.size(); i++) {
            Point p = room.get(i);
            int cnt = 0;
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0) {
                    cnt++;
                }
            }

            if (max < cnt) {
                max = cnt;
                sideRoom.clear();
                sideRoom.add(new Point(p.r, p.c));
            } else if (max == cnt) {
                sideRoom.add(new Point(p.r, p.c));
            }

        }
        return sideRoom;
    }

    private static List<Point> searchEmpty() {
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }
        return list;
    }
}
