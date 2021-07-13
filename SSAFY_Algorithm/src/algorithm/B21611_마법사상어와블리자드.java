package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B21611_마법사상어와블리자드 {
    static int N, M;
    static int map[][];
    static boolean v[][];
    static int sr, sc;
    static int blow[];
    static int dir, dist;
    static Point[] arr;
    static boolean flag;
    static List<Point> removeList;

    static class Point {
        int idx, r, c, value;

        Point(int idx, int r, int c, int value) {
            this.idx = idx;
            this.r = r;
            this.c = c;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "idx=" + idx +
                    ", r=" + r +
                    ", c=" + c +
                    ", value=" + value +
                    '}';
        }
    }

    /**
     * 구슬 파괴 4방
     */
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    /**
     * 나선이동 4방
     */
    static int[] mr = {0, 1, 0, -1};
    static int[] mc = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        blow = new int[3];
        /** 입력 값 채우기*/
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sr = sc = N / 2;
        /** 블리자드 마법을 M번 수행*/
        for (int i = 0; i < M; i++) {
            fillArr();
            st = new StringTokenizer(br.readLine(), " ");
            dir = Integer.parseInt(st.nextToken()) - 1;
            dist = Integer.parseInt(st.nextToken());
            flag = true;
            blizzard(dir, dist);//구슬 파괴(null로 만든다.)
            move();//null로 만든값들 땡기기

            while (flag) {
                bomb();
            }
            divideGroup();
        }


        int sum = 0;
        for (int i = 1; i <= blow.length; i++) {
            sum += (i * blow[i - 1]);
        }
        System.out.println(sum);

    }

    /**
     * 만약, 구슬이 칸의 수보다 많아 칸에 들어가지 못하는 경우 그러한 구슬은 사라진다.
     */
    private static void divideGroup() {
        int idx = 0;
        int cnt = 1;
        int[] newVal = new int[N * N];
        for (int i = 1; i < arr.length; i++) {
            if (idx >= N * N)
                break;
            Point p = arr[i];
            if (p == null) {
                if (arr[i - 1] != null) {
                    groupMap(arr[i - 1].value, cnt, idx, newVal);
                } else {
                    break;
                }
            } else {
                if (p.value == arr[i - 1].value)
                    cnt++;
                else {
                    groupMap(arr[i - 1].value, cnt, idx, newVal);
                    idx += 2;
                    cnt = 1;
                }
            }
        }
        fill(newVal);

    }

    private static void fill(int[] newVal) {
        int idx = 0;
        int r = sr;
        int c = sc;
        int d = 0;
        map = new int[N][N];
        for (int k = 1; k <= N; k++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < k; j++) {
                    if (k == N && j == k - 1)
                        return;
                    r += mr[d];
                    c += mc[d];
                    if (newVal[idx] == 0)
                        map[r][c] = 0;
                    else
                        map[r][c] = newVal[idx];
                    idx++;
                }
                d++;
                if (d == 4)
                    d = 0;
            }
        }
        fillArr();
    }

    private static void groupMap(int value, int cnt, int idx, int[] newVal) {
        newVal[idx++] = cnt;
        if (idx == N * N)
            return;
        newVal[idx] = value;
    }

    private static void bomb() {
        int idx = 0;
        boolean isFlag = false;
        for (int i = 1; i < arr.length; i++) {
            Point p = arr[i];
            if (p == null) {
                if (idx >= 3) {
                    blow[arr[i - 1].value - 1] += (idx + 1);
                    remove(i - 1, idx);
                    isFlag = true;
                    break;
                }
            } else {
                if (p.value == arr[i - 1].value)
                    idx++;
                else {
                    if (idx >= 3) {
                        blow[arr[i - 1].value - 1] += (idx + 1);
                        remove(i - 1, idx);
                        isFlag = true;
                    }
                    idx = 0;
                }
            }
        }
        move();
        if (!isFlag)
            flag = false;
    }

    private static void remove(int idx, int cnt) {
        for (int i = idx; i >= idx - cnt; i--) {
            arr[i] = null;
        }
    }

    private static void move() {
        int idx = 0;
        Point[] copy = new Point[N * N];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) continue;
            copy[idx++] = arr[i];
        }
        arr = copy;
        fillNewMap();

    }

    private static void fillNewMap() {
        int idx = 0;
        int r = sr;
        int c = sc;
        int d = 0;
        map = new int[N][N];
        for (int k = 1; k <= N; k++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < k; j++) {
                    if (k == N && j == k - 1)
                        return;
                    r += mr[d];
                    c += mc[d];
                    if (arr[idx] == null)
                        map[r][c] = 0;
                    else
                        map[r][c] = arr[idx].value;
                    idx++;
                }
                d++;
                if (d == 4)
                    d = 0;
            }
        }
        fillArr();
    }

    private static void blizzard(int dir, int dist) {
        for (int k = 1; k <= dist; k++) {
            int nr = sr + dr[dir] * k;
            int nc = sc + dc[dir] * k;
            delArr(nr, nc);
        }
    }

    private static void delArr(int r, int c) {
        for (int i = 0; i < arr.length; i++) {
            Point p = arr[i];
            if (p != null) {
                if (p.r == r && p.c == c) {
                    arr[i] = null;
                    return;
                }
            }
        }
    }

    private static void fillArr() {
        arr = new Point[N * N];
        int idx = 0;
        int r = sr;
        int c = sc;
        int d = 0;
        for (int k = 1; k <= N; k++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < k; j++) {
                    if (k == N && j == k - 1)
                        return;
                    r += mr[d];
                    c += mc[d];
                    if (map[r][c] == 0)
                        return;
                    arr[idx] = (new Point(idx, r, c, map[r][c]));
                    idx++;
                }
                d++;
                if (d == 4)
                    d = 0;
            }
        }
    }
}
