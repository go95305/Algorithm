package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B17471_게리맨더링_re {
    static int N;
    static ArrayList<Integer>[] list;
    static int[] population;
    static boolean v[];
    static boolean connect[];
    static int tTeam, fTeam;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<Integer>();
        }
        population = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            population[i] = Integer.parseInt(st.nextToken());

        v = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sideNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < sideNum; j++) {
                int to = Integer.parseInt(st.nextToken()) - 1;
                list[i].add(to);
                list[to].add(i);
            }
        }
        ans = Integer.MAX_VALUE;
        powerSet(0, 0);
        if (ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);

    }

    private static void powerSet(int idx, int k) {
        if (idx == v.length) {
            connect = new boolean[N];
//            System.out.println(Arrays.toString(v));
            //만약 선거구가 하나가 아니면
            if (twoOrMore())
                isConnected();

            return;
        }

        v[idx] = true;
        powerSet(idx + 1, k + 1);
        v[idx] = false;
        powerSet(idx + 1, k);
    }


    private static boolean twoOrMore() {
        int a = 0;
        int b = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i])
                a++;
            else
                b++;
        }
        if (a == N || b == N)
            return false;
        return true;
    }

    private static void isConnected() {
        tTeam = 0;
        fTeam = 0;

        for (int i = 0; i < N; i++) {
            if (v[i] && !connect[i]) {
                connect[i] = true;
                tTeam += population[i];
                nextCity(i, true);
                break;
            }
        }
//        System.out.println(tTeam);

        for (int i = 0; i < N; i++) {
            if (!v[i] && !connect[i]) {
                connect[i] = true;
                fTeam += population[i];
                nextCity(i, false);
                break;
            }
        }
//        System.out.println(fTeam);


        if (allChecked()) {
            int diff = Math.abs(tTeam - fTeam);
            ans = Math.min(ans, diff);
        }
    }

    private static boolean allChecked() {
        for (int i = 0; i < connect.length; i++) {
            if (!connect[i])
                return false;
        }
        return true;
    }

    private static void nextCity(int idx, boolean side) {
        int size = list[idx].size();
        for (int i = 0; i < size; i++) {
            if (!connect[list[idx].get(i)] && v[list[idx].get(i)] == side) {
                connect[list[idx].get(i)] = true;
                if (v[list[idx].get(i)])
                    tTeam += population[list[idx].get(i)];
                else
                    fTeam += population[list[idx].get(i)];
                nextCity(list[idx].get(i), side);
            }
        }
    }
}
