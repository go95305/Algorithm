package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2580_스도쿠 {
    static int[][] map;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        int zeroCnt = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    zeroCnt++;
            }
        }

        flag = false;
        putNum(0);
    }

    private static void putNum(int idx) {
        if (idx == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (j != 8)
                        System.out.print(map[i][j] + " ");
                    else
                        System.out.print(map[i][j]);
                }
                System.out.println();
            }
            flag = true;
//            System.exit(0);
            return;
        }

        int r = idx / 9;
        int c = idx % 9;
        if (map[r][c] == 0) {
            for (int k = 1; k <= 9; k++) {
                if (check(r, c, k)) {
                    map[r][c] = k;
                    putNum(idx + 1);
                    map[r][c] = 0;
                    if (flag)
                        return;
                }
            }
        } else
            putNum(idx + 1);

    }

    private static boolean check(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[r][i] == num || map[i][c] == num)
                return false;
        }


        int row = (r / 3) * 3;
        int col = (c / 3) * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (map[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}
