package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_re {
    static int N, M;
    static int map[][];
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int remain = 0;
        int time = 0;
        int currentSize = 0;
        while (true) {//전부 녹기 전까지 진행
            v = new boolean[N][M];
            Queue<Point> que = new LinkedList<>();
            que.add(new Point(0, 0));
            v[0][0] = true;
            while (!que.isEmpty()) {
                Point p = que.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if (nr >=0 && nr < N  && nc >= 0 && nc < M  && !v[nr][nc]) {
                        v[nr][nc] = true;
                        if (map[nr][nc] == 1) {
                            map[nr][nc] = 2;
                        } else if (map[nr][nc] == 0) {
                            que.add(new Point(nr, nc));
                        }
                    }
                }
            }
            //시간 추가
            time++;

            currentSize = cntLeftOver();
            //겉 부분은 2로 설정, 이제 겉부분 자르기
            cutoffMelted();
            //현재 남은 치즈 확인
            remain = cntLeftOver();
            if (remain == 0)
                break;
        }

        System.out.println(time);
        System.out.println(currentSize);
    }

    private static int cntLeftOver() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >0)
                    cnt++;
            }
        }
        return cnt;
    }

    private static void cutoffMelted() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2)
                    map[i][j] = 0;
            }
        }
    }
}
