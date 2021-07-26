package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1025_제곱수찾기 {
    static int N, M;
    static int ans;
    static int map[][];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //등차를 앞 뒤 행 열 에서 수행할 수 있어야 하므로 -값부터 +값 까지 수행
                for (int x = -N ; x < N; x++) {
                    for (int y = -M ; y < M; y++) {
                        if (x == 0 && y == 0) continue;//계속 0 이 더해지면 아래 while에서 무한루프에 걸린다.
                        int a = i;
                        int b = j;
                        int now = 0;
                        while (a >= 0 && a < N && b >= 0 && b < M) {
                            now *= 10;
                            now += map[a][b];
                            if (isValid(now)) {
                                ans = Math.max(ans, now);
                            }
                            /** 등차가 가능한 이전 행,열 범위부터 다음 행,열 범위 까지 찾기 */
                            a += x;
                            b += y;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean isValid(int now) {
        int num = (int) Math.sqrt(now);
        if (num * num == now)
            return true;
        return false;
    }
}
