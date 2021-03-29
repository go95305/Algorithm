package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14889_스타트와링크 {
    static int N;
    static int map[][];
    static int sel[];
    static boolean v[];
    static int team[];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        team = new int[N];
        for (int i = 0; i < N; i++) {
            team[i] = i;
        }
        ans = Integer.MAX_VALUE;
        v = new boolean[N];
        sel = new int[N / 2];
        combi(0, 0);
        System.out.println(ans);
    }

    private static void combi(int idx, int k) {
        if (k == N / 2) {
            int tmp[] = new int[N];
            for (int i = 0; i < sel.length; i++) {
                tmp[sel[i]]++;
            }
            int link[] = new int[N / 2];
            int index = 0;
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] == 0) {
                    link[index] = i;
                    index++;
                }
            }
            int sScore = startScore(sel);
            int lScore = startScore(link);
            ans = Math.min(ans, Math.abs(sScore - lScore));

            return;
        }

        for (int i = idx; i < team.length; i++) {
            sel[k] = team[i];
            combi(i + 1, k + 1);
        }
    }

    private static int startScore(int[] tmp) {

        int sum = 0;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = i + 1; j < tmp.length; j++) {
                sum += map[tmp[i]][tmp[j]] + map[tmp[j]][tmp[i]];
            }
        }
        return sum;
    }
}
