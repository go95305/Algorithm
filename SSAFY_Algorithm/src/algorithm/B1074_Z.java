package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074_Z {
    static int N;
    static int r, c;
    static int ans;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int num = (int) Math.pow(2, N);
        ans = 0;
        powerSet(0, 0, num, 0);
        System.out.println(ans);

    }

    private static void powerSet(int row, int col, int size, int cnt) {
        if (flag)
            return;

        if (size == 2) {
            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    if (i == r && j == c) {
                        ans = cnt;
                        flag = true;
                        return;
                    }
                    cnt++;
                }
            }
        }

        if (size >= 4) {
            if (r < row + size / 2 && c < col + size / 2)
                powerSet(row, col, size / 2, cnt);
            else if (r < row + size / 2 && c >= col + size / 2)
                powerSet(row, col + size / 2, size / 2, cnt + ((size / 2) * (size / 2)));
            else if (r >= row + size / 2 && c < col + size / 2)
                powerSet(row + size / 2, col, size / 2, cnt + (size * size / 2));
            else
                powerSet(row + size / 2, col + size / 2, size / 2, cnt + ((size / 2) * (size / 2) + (size / 2) * (size / 2) + ((size / 2) * (size / 2))));
        }


    }
}
