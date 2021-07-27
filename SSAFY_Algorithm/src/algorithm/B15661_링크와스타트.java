package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15661_링크와스타트 {
    static int N;
    static int map[][];
    static boolean v[];
    static int ans;

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
        v = new boolean[N];
        ans = Integer.MAX_VALUE;
        combination(0, 0);
        System.out.println(ans);
    }

    private static void combination(int idx, int k) {
        if (k == N) {//모든 선수가 같은 팀이 되는 경우이므로 바로 리턴
            return;
        }

        team();

        for (int i = idx; i < N; i++) {
            v[i] = true;
            combination(i + 1, k + 1);
            v[i] = false;
        }
    }

    private static void team() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < v.length; i++) { //스타트팀
            if (v[i]) {
                for (int j = i + 1; j < N; j++) {
                    if (i == j || !v[j]) continue;
                    start += map[i][j];
                    start += map[j][i];
                }
            }
        }

        for (int i = 0; i < v.length; i++) {//링크팀
            if (!v[i]) {
                for (int j = i + 1; j < N; j++) {
                    if (i == j || v[j]) continue;
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        ans = Math.min(ans, Math.abs(start - link));
    }
}
