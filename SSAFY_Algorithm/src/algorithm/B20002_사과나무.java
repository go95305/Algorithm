package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20002_사과나무 {
    static int N;
    static int map[][];
    static int ans;
    static int dr[] = {-1, 0, -1};
    static int dc[] = {0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MIN_VALUE;
        add();
        large();
        System.out.println(ans);
    }

    private static void large() {
        for (int i = 0; i < N; i++) {
            for (int r = i; r < N; r++) {
                for (int c = i; c < N; c++) {
                    int sum = map[r][c];
                    for (int k = 0; k < 3; k++) {
                        int nr = r + dr[k] * (i + 1);
                        int nc = c + dc[k] * (i + 1);
                        if (nr >= 0 && nc >= 0) {
                            if (k == 2)
                                sum += map[nr][nc];
                            else
                                sum -= map[nr][nc];
                        }
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }
    }

    private static void add() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) continue;
                int sum = 0;
                if (i - 1 >= 0)
                    sum += map[i - 1][j];
                if (j - 1 >= 0)
                    sum += map[i][j - 1];
                if (i - 1 >= 0 && j - 1 >= 0)
                    sum -= map[i - 1][j - 1];
                map[i][j] = map[i][j] + sum;
            }
        }
    }
}
