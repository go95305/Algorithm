package algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14503_로봇청소기 {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int N, M;
    static int map[][];
    static boolean v[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        boolean flag = false;
        v = new boolean[N][M];
        while (true) {
            if (flag)
                break;
            //1. 현재 위치를 청소한다.
            v[r][c] = true;
            ans++;
            while (true) {

                //2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행.
                //현재 바라보는 방향에서 왼쪽 행에 청소 안한칸이 존재하는지이 존재하는지
                boolean leftExist = leftChk(r, c, d);
                //현재 바라보는 방향에서 왼쪽에 아직 청소하지 않은 공간이 존재
                if (leftExist) {
                    //방향 바꾸고 한칸 전진
                    d -= 1;
                    if (d < 0)
                        d = 3;
                    r = r + dr[d];
                    c = c + dc[d];

                    break;
                }
                //현재 바라보는 방향에서 왼쪽에 청소할 공간이 남아 있지 않다면이 조재하지 않으면면
                else {
                    //4방향 모두 청소가 이미 되어 있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한칸 후진을 하고 2번으로
                    //4방 탐색
                    boolean fourwayChk = wayChk(r, c, d);
                    if (fourwayChk) {
                        int dd = d;

                        dd += 2;
                        if (dd > 3) {
                            dd = dd - 4;
                        }
                        //뒤쪽이 벽이 아니면
                        r = r + dr[dd];
                        c = c + dc[dd];
                        if (map[r][c] != 1)
                            continue;
                        else {
                            flag = true;
                            break;
                        }

                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean wayChk(int r, int c, int d) {

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M)
                if (v[nr][nc] || map[nr][nc] == 1)
                    return true;
        }
        return false;

    }

    private static boolean leftChk(int r, int c, int d) {
        d -= 1;
        if (d < 0)
            d = 3;
        int nr = r + dr[d];
        int nc = c + dc[d];
        if (!v[nr][nc] && map[nr][nc] != 1)
            return true;
        return false;
    }
}