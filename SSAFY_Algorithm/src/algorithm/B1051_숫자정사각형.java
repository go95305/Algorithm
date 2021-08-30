package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1051_숫자정사각형 {
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int ans = 1;
        int area = 1;
        int r = 0;
        int c = 0;

        while (r + area < row && c + area < col) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i + area < row && j + area < col) {
                        if (same(i, j, area)) {
                            int size = (area + 1) * (area + 1);
                            ans = Math.max(ans, size);
                        }
                    }
                }
            }
            area++;
        }
        System.out.println(ans);
    }

    private static boolean same(int r, int c, int area) {
        if (map[r][c] == map[r + area][c] && map[r + area][c] == map[r][c + area] && map[r + area][c + area] == map[r][c + area] && map[r][c] == map[r + area][c + area]) {
            return true;
        }
        return false;
    }
}
