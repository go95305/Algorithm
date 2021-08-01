package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17822_원판돌리기 {
    static int N, M, T;
    static int map[][];
    static boolean v[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            spin(X, D, K);
            isAdj();
            ans = addAll();
        }
        System.out.println(ans);
    }


    private static int addAll() {
        int sum = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                sum += map[i][j];
        return sum;
    }

    private static void isAdj() {// 0은 확인안하게 하자.
        v = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {//행 검사
            for (int j = 1; j < M; j++) {
                if (map[i][j] == map[i][j - 1] && map[i][j] != 0) {
                    v[i][j] = true;
                    v[i][j - 1] = true;
                }
            }
            if (map[i][0] == map[i][M - 1] && map[i][0] != 0) { //처음과 끝 검사
                v[i][0] = true;
                v[i][M - 1] = true;
            }
        }

        for (int i = 0; i < M; i++) {//열검사
            for (int j = 1; j < N; j++) {
                if (map[j][i] == map[j - 1][i] && map[j][i] != 0) {
                    v[j][i] = true;
                    v[j - 1][i] = true;
                }
            }
        }
        cnt = count();
        if (cnt == 0) {
            avgSumMin();
        } else {
            delete();
        }

    }

    private static void delete() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if (v[i][j])
                    map[i][j] = 0;
            }
    }

    private static void avgSumMin() {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    sum += map[i][j];
                    cnt++;
                }
            }
        }
        double avg = (float) sum / (float) cnt;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > avg && map[i][j] != 0)
                    map[i][j]--;
                else if (map[i][j] < avg && map[i][j] != 0)
                    map[i][j]++;
            }
        }

    }

    private static int count() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                if (v[i][j])
                    cnt++;
        }
        return cnt;
    }

    private static void spin(int x, int d, int k) {
        for (int i = 0; i < N; i++) {
            if ((i + 1) % x == 0) {//배수인 경우
                if (d == 0) {//시계방향
                    for (int s = 0; s < k; s++) {
                        int tmp = map[i][M - 1];
                        for (int j = M - 1; j > 0; j--) {
                            map[i][j] = map[i][j - 1];
                        }
                        map[i][0] = tmp;
                    }
                } else {//반 시계방향
                    for (int s = 0; s < k; s++) {
                        int tmp = map[i][0];
                        for (int j = 0; j < M - 1; j++) {
                            map[i][j] = map[i][j + 1];
                        }
                        map[i][M - 1] = tmp;
                    }
                }
            }
        }
    }
}
