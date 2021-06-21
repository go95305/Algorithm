package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14719_빗물 {
    static int H, W;
    static int[][] map;
    static boolean v[][];
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
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        v = new boolean[H][W];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < W; i++) {
            int block = Integer.parseInt(st.nextToken());
            for (int j = H - 1; j >= H - block; j--) {
                map[j][i] = 1;//블록은 1로 채운다.
            }
        }

        //왼아래부터 탐색하며 빗물이 고일 수 있은곳 (0)을 찾는다.
        for (int i = 0; i < W; i++) {
            for (int j = H - 1; j >= 0; j--) {
                if (!v[j][i] && map[j][i] == 0 && isPuddle(j, i)) {
//                    System.out.println("start :"+j+" "+i);
                    isWater(j, i);
                }
            }
        }
//        print();

        int ans = puddleChk();
        System.out.println(ans);
    }

    private static int puddleChk() {
        int cnt = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                if (v[i][j])
                    cnt++;
            }
        }
        return cnt;
    }

    private static void print() {
        for (int i = 0; i < v.length; i++) {
            System.out.println(Arrays.toString(v[i]));
        }
    }

    private static boolean isPuddle(int r, int c) {
        //우측 탐색
        int nc = c;
        while (nc < W) {
            if (map[r][nc] == 0) {
                if (nc == W - 1) {
                    return false;
                }
            } else {
                break;
            }
            nc++;
        }
        //좌측 탐색

        nc = c;
        while (nc >= 0) {
            if (map[r][nc] == 0) {
                if (nc == 0) {
                    return false;
                } else
                    nc--;
            } else {
                return true;
            }
        }
        return true;
    }

    private static void isWater(int r, int c) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(r, c));
        v[r][c] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < H && nc >= 0 && nc < W && isPuddle(nr, nc) && !v[nr][nc] && map[nr][nc] == 0) {
                    v[nr][nc] = true;
//                    System.out.println(nr + " " + nc);
                    map[nr][nc] = 1;
//                    ans++;
                    que.add(new Point(nr, nc));
                }
            }
        }
    }
}
