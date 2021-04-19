package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16918_봄버맨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        char map[][] = new char[R][C];
        int v[][] = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                v[i][j] = -1;
            }
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'O')
                    v[i][j] = 0;
            }
        }

        int cnt = 1;
        while (cnt < N) {
            cnt++;
//            System.out.println(cnt);
            //설치된 위치 외에 전부 설치
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '.') {
                        map[i][j] = 'O';
                        v[i][j] = cnt;
                    }
                }
            }
//            print(map, R);
            if (cnt == N)
                break;
            cnt++;
//            System.out.println(cnt);
            //3초전 폭탄 폭발
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (v[i][j] == (cnt - 3)) {
                        map[i][j] = '.';
                        for (int k = 0; k < 4; k++) {
                            int nr = i + dr[k];
                            int nc = j + dc[k];
                            if (nr >= 0 && nr < R && nc >= 0 && nc < C)
                                map[nr][nc] = '.';
                        }
                    }
                }
            }
//            print(map, R);
        }
        print(map, R, C);

    }

    private static void print(char[][] map, int R, int C) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }
}
