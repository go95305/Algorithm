package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA4615_재미있는오셀로게임 {
    static char map[][];
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean flag;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            int M;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][N];

            //맵 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = '.';
                }
            }

            //초기화(크기에 따라 다르다)

            map[N/2-1][N/2-1] = 'W';
            map[N/2-1][N/2] = 'B';
            map[N/2][N/2-1] = 'B';
            map[N/2][N/2] = 'W';

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                int turn = Integer.parseInt(st.nextToken());

                char stone = 'a';
                if (turn == 1) {
                    map[r][c] = 'B';
                    stone = 'B';
                } else {
                    map[r][c] = 'W';
                    stone = 'W';
                }
                //8방 탐색
                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != '.') {
                        flag = false;
                        goNext(nr, nc, stone, d);
                    }
                }
//                print();
            }

            getStoneCnt(tc);


        }
    }

    private static void print() {
        for (int i=0;i<N;i++){
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    private static void getStoneCnt(int tc) {
        int black = 0;
        int white = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'B')
                    black++;
                else if (map[i][j] == 'W')
                    white++;
            }
        }

        System.out.printf("#%d %d %d\n", tc, black, white);
    }

    private static void goNext(int r, int c, char color, int dir) {
        if (map[r][c] == color) {
            flag = true;
            return;
        }

        int nr = r + dr[dir];
        int nc = c + dc[dir];
        if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != '.') {
            goNext(nr, nc, color, dir);
        }

        if (flag)
            map[r][c] = color;
    }
}
