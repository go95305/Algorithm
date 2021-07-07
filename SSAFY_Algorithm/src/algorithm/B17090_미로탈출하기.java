package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17090_미로탈출하기 {
    static int N, M;
    static char map[][];
    static boolean v[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int ans;
    static boolean flag;
    static boolean isOut[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isOut = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String direction = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = direction.charAt(j);
            }
        }
        ans = 0;
        v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!v[i][j]) {
                    flag = false;
                    v[i][j] = true;
                    findExit(i, j);
                } else {
                    if (isOut[i][j]) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static void findExit(int r, int c) {


        char way = map[r][c];
        int nr = 0;
        int nc = 0;
        int dir = 0;
        if (way == 'U')
            dir = 0;
        else if (way == 'R')
            dir = 3;
        else if (way == 'D')
            dir = 1;
        else
            dir = 2;
        nr = r + dr[dir];
        nc = c + dc[dir];

        if (nr < 0 || nr >= N || nc < 0 || nc >= M) { //밖으로 나가는 거
            flag = true;
            isOut[r][c] = true;
            ans++;

        } else {
            if (!v[nr][nc]) {
                v[nr][nc] = true;
                findExit(nr, nc);
                if (flag) {
                    isOut[r][c] = true;

                }
            } else {
                if (isOut[nr][nc]) {
                    ans++;
                    isOut[r][c] = true;
                    flag=true;

                }
            }
        }

    }
}
