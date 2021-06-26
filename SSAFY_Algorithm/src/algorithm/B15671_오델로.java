package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15671_오델로 {
    static char map[][];
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[6][6];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = '.';
            }
        }

        //초기 세팅
        map[2][2] = 'W';
        map[3][3] = 'W';
        map[2][3] = 'B';
        map[3][2] = 'B';

        boolean isTurn = true;//true:흑 false: 백
        int turn = Integer.parseInt(br.readLine());
        for (int i = 0; i < turn; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            char stone = 'a';
            if (isTurn) {
                map[r][c] = 'B';
                stone = 'B';
            } else {
                map[r][c] = 'W';
                stone = 'W';
            }

            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < 6 && nc >= 0 && nc < 6 && map[nr][nc]!='.') {
                    flag = false;
                    goNext(nr, nc, stone, d);
                }
            }


            isTurn = !isTurn;//차례바꾸기
        }

        print();
        cntColor();
    }

    private static void cntColor() {
        int white = 0;
        int black = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] == 'W')
                    white++;
                else if (map[i][j] == 'B')
                    black++;
            }
        }
        if (black > white)
            System.out.println("Black");
        else if (black < white)
            System.out.println("White");
    }

    private static void print() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void goNext(int r, int c, char stone, int dir) {
        //진행하다가 만약 색깔이 같은게 나왔으면 이제 그만 리턴하고 사이에 돌들을 색깔을다 바꾼다.
        if (map[r][c] == stone) {
            flag = true;
            return;
        }

        int nr = r + dr[dir];
        int nc = c + dc[dir];
        if (nr >= 0 && nr < 6 && nc >= 0 && nc < 6 && map[nr][nc] != '.')
            goNext(nr, nc, stone, dir);

        if (flag)
            map[r][c] = stone;

    }


}
