package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14890_경사로 {
    static int N, L;
    static int map[][];
    static boolean v[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        //좌우, 상하
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            boolean levelChange = false;
            for (int j = 1; j < N; j++) {
                if (map[i][j] > map[i][j - 1]) {//이전 보다 크면 <-로 경사로 설치 확인
                    levelChange = true;
                    boolean tmp = step(i, j, 2);
                    if (tmp) {//경사로 설치가 가능하면 경사로 설치
                        makeStep(i, j, 2);
                    } else {
                        flag = false;
                        break;
                    }
                } else if (map[i][j] < map[i][j - 1]) { //이전 보다 작으면 -> 로 경사로 설치 확인
                    levelChange = true;
                    boolean tmp = step(i, j - 1, 3);
                    if (tmp) {
                        makeStep(i, j - 1, 3);
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && !levelChange)
                ans++;
            else if (flag)
                ans++;
        }
        v = new boolean[N][N];
        //상하
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            boolean levelChange = false;
            for (int j = 1; j < N; j++) {
                if (map[j][i] > map[j - 1][i]) {//이전보다 크면 위로 경사로 설치
                    levelChange = true;
                    boolean tmp = step(j, i, 0);
                    if (tmp) {//경사로 설치가 가능하면 경사로 설치
                        makeStep(j, i, 0);
                    } else {
                        flag = false;
                        break;
                    }
                } else if (map[j][i] < map[j - 1][i]) { //이전 보다 작으면 -> 로 경사로 설치 확인
                    levelChange = true;
                    boolean tmp = step(j - 1, i, 1);
                    if (tmp) {
                        makeStep(j - 1, i, 1);
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && !levelChange)
                ans++;
            else if (flag)
                ans++;
        }
        System.out.println(ans);
    }

    private static void makeStep(int r, int c, int dir) {
        for (int i = 1; i <= L; i++) {
            int nr = r + dr[dir] * i;
            int nc = c + dc[dir] * i;
            v[nr][nc] = true;
        }
    }

    private static boolean step(int r, int c, int dir) {
        boolean isStep = true;
        for (int i = 1; i <= L; i++) {
            int nr = r + dr[dir] * i;
            int nc = c + dc[dir] * i;
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != map[r][c] - 1 || v[nr][nc]) {
                isStep = false;
                break;
            }
        }
//        System.out.println(r + " " + c + " " + isStep);
        return isStep;
    }
}
