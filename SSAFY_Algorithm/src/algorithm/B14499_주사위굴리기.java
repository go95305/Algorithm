package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14499_주사위굴리기 {
    static int N, M, K;
    static int map[][];
    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {1, -1, 0, 0};
    static int value[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        value = new int[6];
        int cur = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                changeDice(dir);
                if (map[nr][nc] != 0) { // map숫자가 주사위로 복사,map[r][c]==0으로 설정
                    value[0] = map[nr][nc];
                    map[nr][nc] = 0;
                } else { // 주사위 숫자가 map으로 복
                    map[nr][nc] = value[0];
                }
                System.out.println(value[5]);
                r = nr;
                c = nc;
            }
        }

    }

    private static void changeDice(int d) {
        int tmp[] = value.clone();
        if (d == 0) {//동
            tmp[0] = value[2];
            tmp[2] = value[5];
            tmp[3] = value[0];
            tmp[5] = value[3];
        } else if (d == 1) {//서
            tmp[0] = value[3];
            tmp[2] = value[0];
            tmp[3] = value[5];
            tmp[5] = value[2];
        } else if (d == 2) {//북
            tmp[0] = value[1];
            tmp[1] = value[5];
            tmp[4] = value[0];
            tmp[5] = value[4];
        } else {//남
            tmp[0] = value[4];
            tmp[1] = value[0];
            tmp[4] = value[5];
            tmp[5] = value[1];
        }
        value = tmp;
    }
}
