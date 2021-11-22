package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1025_제곱수찾기 {
    static int N, M;
    static int map[][];
    static int dr[] = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int dc[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static int ans; //최대값 갱신
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        ans = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int l = -N; l < N; l++) {
                    for (int m = -M; m < M; m++) {
                        if (l == 0 && m == 0) continue;
                        int a = i;
                        int b = j;
                        int now = 0;
                        while (a >= 0 && a < N && b >= 0 && b < M) {
                            now *= 10;
                            now += map[a][b];
                            if (isValid(now)) {
                                ans = Math.max(ans, now);
                            }

                            a += l;
                            b += m;
                        }
                    }
                }
            }
        }
        System.out.println(ans);


    }

    private static boolean isValid(int now) {
        int num = (int) Math.sqrt(now);
        if (num * num == now) {
            return true;
        }
        return false;
    }
}
