package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B6593_상범빌딩 {
    static int dl[] = {0, 0, 0, 0, 1, -1};
    static int dr[] = {-1, 1, 0, 0, 0, 0};
    static int dc[] = {0, 0, -1, 1, 0, 0};

    static class Point {
        int l, r, c, cnt;

        Point(int l, int r, int c, int cnt) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0)
                break;
            Queue<Point> que = new LinkedList<>();
            char[][][] map = new char[L][R][C];
            boolean v[][][] = new boolean[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    st = new StringTokenizer(br.readLine(),"");
                    String tmp = st.nextToken();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = tmp.charAt(k);
                        if (map[i][j][k] == 'S') {
                            que.add(new Point(i, j, k, 0));
                            v[i][j][k]=true;
                        }
                    }
                }
                br.skip(1);
            }
            int time = 0;
            while (!que.isEmpty()) {
                Point p = que.poll();
                if (map[p.l][p.r][p.c] == 'E') {
                    time = p.cnt;
                    break;
                }
                for (int k = 0; k < 6; k++) {
                    int nl = p.l + dl[k];
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C && !v[nl][nr][nc] && map[nl][nr][nc] != '#') {
                        v[nl][nr][nc]=true;
                        que.add(new Point(nl, nr, nc, p.cnt + 1));
                    }
                }
            }
            if (time == 0)
                System.out.println("Trapped!");
            else
                System.out.println("Escaped in "+time+" minute(s).");
        }
    }
}
