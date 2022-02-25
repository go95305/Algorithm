package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 윌리암슨수액빨이딱따구리 {
    static int N, M;
    static int map[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int ans;

    static class Point {
        int r, c, cnt;

        Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Point s = null;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j) - '0';
                if (map[i][j] == 2)
                    s = new Point(i, j, 0);
            }
        }
        ans = 0;
        bfs(s);
        if (ans==0){
            System.out.println("NIE");
        }else{
            System.out.println("TAK");
            System.out.println(ans);
        }

    }

    private static void bfs(Point s) {
        boolean v[][] = new boolean[N][M];
        Queue<Point> que = new LinkedList<>();
        que.add(s);
        v[s.r][s.c] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (map[p.r][p.c] != 2 && map[p.r][p.c] > 1) {
                ans = p.cnt;
                return;
            }
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] != 1) {
                    v[nr][nc] = true;
                    que.add(new Point(nr, nc, p.cnt + 1));
                }
            }
        }
    }
}
