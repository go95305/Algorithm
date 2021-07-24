package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int map[] = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0)
                map[i] = Integer.parseInt(st.nextToken());
            else
                map[i] = map[i - 1] + Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            System.out.println(add(from, to, map));
        }
    }

    private static int add(int from, int to, int[] map) {
        if (from == 0)
            return map[to];
        else
            return map[to] - map[from - 1];
    }
}
