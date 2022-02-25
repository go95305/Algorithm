package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16987_계란으로계란치기 {
    static int N;
    static int ans;

    static class Egg {
        int hp;
        int weight;

        Egg(int hp, int weight) {
            this.hp = hp;
            this.weight = weight;
        }


        @Override
        public String toString() {
            return "Egg{" +
                    "hp=" + hp +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Egg eg[] = new Egg[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int hp = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eg[i] = new Egg(hp, weight);
        }

        dfs(0, eg, 0);
        System.out.println(ans);
    }

    private static void dfs(int idx, Egg[] eg, int broken) {
        if (idx == N) {
            ans = Math.max(ans, broken);
            return;
        }

        if (eg[idx].hp <= 0) {//휘두를 계란이 이미 깨진거라면
            dfs(idx + 1, eg, broken);//그오른쪽거를 집는다.
            return; //깨진 계란으로 진행하면 안되므로 리턴
        }
        //휘두를수 있게 깨지지 않은 계란이라면
        for (int i = 0; i < eg.length; i++) {
            int curBroken = 0;
            if (idx != i) {
                if (eg[i].hp > 0) {
                    eg[idx].hp -= eg[i].weight;
                    if (eg[idx].hp <= 0)
                        curBroken++;
                    eg[i].hp -= eg[idx].weight;
                    if (eg[i].hp <= 0)
                        curBroken++;
                    dfs(idx + 1, eg, broken + curBroken);
                    eg[idx].hp += eg[i].weight;
                    eg[i].hp += eg[idx].weight;
                }
            }
        }
        //계란을 순서대로 다 고르기전에 다 깨져버리면(위의 N번수행 리턴조건 전에 끝날 경우)
        ans = Math.max(ans, broken);

    }
}
