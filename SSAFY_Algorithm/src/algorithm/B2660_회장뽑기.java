package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B2660_회장뽑기 {
    static class Rank implements Comparable<Rank> {
        int num, fCnt;

        Rank(int num, int fCnt) {
            this.num = num;
            this.fCnt = fCnt;
        }

        @Override
        public int compareTo(Rank o) {
            if (this.fCnt == o.fCnt) {
                if (this.num < o.num)
                    return this.num;
                else
                    return o.num;
            } else {
                return this.fCnt - o.fCnt;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int map[][] = new int[N][N];
        int INF = 9999999;
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i < N; i++) {
            map[i][i] = 0;
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (from == -1 && to == -1)
                break;
            map[from - 1][to - 1] = 1;
            map[to - 1][from - 1] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (i == k) continue;
                for (int j = 0; j < N; j++) {
                    if (j == k || i == j) continue;
                    if (map[i][k] + map[k][j] < map[i][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }
        Rank president[] = new Rank[N];
        for (int i = 0; i < N; i++) {
            int high = 0;
            for (int j = 0; j < N; j++) {
                if (high < map[i][j])
                    high = map[i][j];
            }
            president[i] = new Rank(i, high);
        }
        Arrays.sort(president);
        int score = president[0].fCnt;
        int cnt = 0;
        List<Rank> list = new ArrayList<>();
        for (int i = 0; i < president.length; i++) {
            if (president[i].fCnt == score) {
                cnt++;
                list.add(president[i]);
            }
        }
        System.out.println(score + " " + cnt);
        for (int i = 0; i < list.size(); i++) {
            Rank r = list.get(i);
            if (i != list.size() - 1) {
                System.out.print(r.num + 1 + " ");
            } else
                System.out.print(r.num + 1);
        }
    }
}
