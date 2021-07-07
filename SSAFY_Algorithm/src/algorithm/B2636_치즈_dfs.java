package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2636_치즈_dfs {
    static int N, M;
    static int map[][];
    static boolean v[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int cnt, cheeze;

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
                if (map[i][j] == 1)
                    cheeze++;
            }
        }
        int ans = 0;
        int turn = 0;
        while (true) {
            cnt = 0;
            v = new boolean[N][M];
            v[0][0] = true;
            searchCheeze(0, 0);
            deleteCheeze();
            turn++;
            if (cheeze == 0) {
                System.out.println(turn);
                System.out.println(cnt);
                break;
            }
        }

    }

    private static void deleteCheeze() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    cheeze--;
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void searchCheeze(int r, int c) {

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]) {
                v[nr][nc] = true;
                if (map[nr][nc] == 0)
                    searchCheeze(nr, nc);
                else {
                    map[nr][nc] = 2;
                    cnt++;
                }
            }
        }
    }
}
/*
0,0부터 탐색을 통해 0 이면 que에 넣고, 1이면 2로 만들고 그대로 진행
제거 전에 개수 확인
2인 부분 전부 제거
다시 반복
 */