package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15684_사다리조작 {
    static int N, M, H;
    static int map[][];
    static int ans;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            map[row][col] = 1;
            map[row][col + 1] = 2;
        }
        for (int i = 0; i <= 3; i++) {
            ans = i;
            dfs(0, 0);
            if (flag)
                break;
        }
        if (flag)
            System.out.println(ans);
        else
            System.out.println(-1);

    }

    private static void dfs(int idx, int cnt) {
        if (flag)
            return;
        if (cnt == ans) {
//            print();
            if (check()) {
                flag = true;
            }
            return;
        }


        for (int i = idx; i < H; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(i, cnt + 1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }

    }

    private static boolean check() {
        for (int i = 0; i < N; i++) { // 4
            int r = 0;//
            int c = i;
            for (int j = 0; j < H; j++) { //4
                if (map[r][c] == 1)
                    c++;
                else if (map[r][c] == 2)
                    c--;
                r++;
            }
            if (i != c)
                return false;

        }
        return true;
    }
}
