package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양팔저울 {
    static int K;
    static int S;
    static int chu[];
    static boolean val[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        chu = new int[K];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            int val = Integer.parseInt(st.nextToken());
            chu[i] = val;
            S += val;
        }
        val = new boolean[S + 1];

        solve(0, 0);
        int ans = getNotPossible();
        System.out.println(ans);


    }

    private static int getNotPossible() {
        int cnt = 0;
        for (int i = 0; i < val.length; i++) {
            if (!val[i])
                cnt++;
        }
        return cnt;
    }

    private static void solve(int idx, int weight) {
        if (idx == K) {//추를 K개 다 사용했을때
            if (weight >= 0) {
                val[weight] = true; //해당 무게가 존재한다.
            }
            return;
        }

        solve(idx + 1, weight);
        solve(idx + 1, weight + chu[idx]);
        solve(idx + 1, weight - chu[idx]);
    }
}
