package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long map[] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            map[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(map);
        int s = 0;
        int e = N - 1;
        long[] answer = new long[2];
        answer[0] = map[0];
        answer[1] = map[N - 1];
        long ans = Long.MAX_VALUE;
        while (s < e) {
            long sum = Math.abs(map[s] + map[e]);
            if (sum < ans) {
                ans = sum;
                answer[0] = map[s];
                answer[1] = map[e];
            }
            /** 두 수를 더했을때 0보다 작으면 s를 더 큰 수를 가리키도록 인덱스를 ++해주면
             * 0에 더 가까워진다.
             * */
            if (map[s] + map[e] < 0) {
                s++;
            } else {
                e--;
            }
        }
        System.out.print(answer[0] + " " + answer[1]);
    }
}
