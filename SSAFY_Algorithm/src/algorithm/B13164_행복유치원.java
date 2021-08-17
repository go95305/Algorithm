package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13164_행복유치원 {
    static int N, K;
    static int map[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        int diff[] = new int[N - 1];
        for (int i = 1; i < N; i++) {
            diff[i - 1] = map[i] - map[i - 1];
        }
        Arrays.sort(diff);
        int sum = 0;
        for (int i = 0; i < N - K; i++)
            sum += diff[i];
        System.out.println(sum);
    }
}
