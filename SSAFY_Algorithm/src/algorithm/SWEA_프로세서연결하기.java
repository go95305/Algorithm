package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_프로세서연결하기 {
    static int N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans;
    static int maxCore;
    static int totalCore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            totalCore = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i != 0 && j != 0 && map[i][j] == 1)
                        totalCore++;
                }
            }
//            System.out.println(totalCore);
            ans = Integer.MAX_VALUE;
            maxCore = 0;
            maxinos(0, new boolean[N][N], 0, 0);
            if (ans == Integer.MAX_VALUE)
                System.out.printf("#%d %d\n", tc, 0);
            else
                System.out.printf("#%d %d\n", tc, ans);
        }
    }

    private static void maxinos(int cnt, boolean[][] v, int core, int idx) {

        out:
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (map[i][j] == 1 && !v[i][j]) {
                    boolean dir = true;
                    for (int d = 0; d < 4; d++) {
                        if (isDir(i, j, d, v)) { //해당 방향으로 쭉 이동하여 전원에 연결되면

                            dir = false;
                            //새로운 방문 바열 만들고
                            boolean[][] b = new boolean[N][];
                            newVisit(b, v);
                            b[i][j] = true;
                            //해당 방향으로 쭉 체크하고 개수 세기
                            int wire = setVisit(b, i, j, d);
                            //재귀 보내기
                            maxinos(cnt + wire, b, core + 1, idx + 1);
                        }
                    }
                    if (!dir)
                        break out;
                }
            }
        }

        //최대한 많은 코어수 일경우 이므로, 코어수가 다 연결 안될 수 도 있다. 그러므로 조건을 루프 끝나고 나서 하는 게 맞다.
        if (maxCore == core) {
            ans = Math.min(ans, cnt);
        } else if (maxCore < core) {
            maxCore = core;
            if (ans < cnt)
                ans = cnt;
        }

    }

    private static int leftCore(boolean[][] v) {
        int cnt = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (map[i][j] == 1 && !v[i][j])
                    cnt++;
            }
        }
        return cnt;
    }

    private static int setVisit(boolean[][] b, int r, int c, int d) {
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            int nr = r + dr[d] * i;
            int nc = c + dc[d] * i;
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                b[nr][nc] = true;
                cnt++;
            }
        }
        return cnt;
    }

    private static void newVisit(boolean[][] b, boolean[][] v) {
        for (int i = 0; i < N; i++) {
            b[i] = v[i].clone();
        }
    }

    private static boolean isDir(int r, int c, int d, boolean[][] v) { //한 방향 쭉 탐색
        for (int i = 1; i < N; i++) {
            int nr = r + dr[d] * i;
            int nc = c + dc[d] * i;
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (v[nr][nc])
                    return false;
                else {
                    if (map[nr][nc] == 1)
                        return false;
                    else {
                        if ((nr == 0 || nc == 0) || (nr == N - 1 || nc == N - 1))
                            return true;
                    }
                }
            }
        }
        return false;
    }
}
