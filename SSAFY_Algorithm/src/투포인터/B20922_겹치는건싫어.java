package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20922_겹치는건싫어 {
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

        int s = 0;
        int e = 0;
        int arr[] = new int[100001];

        int ans = 0;
        for (int i = 1; i < N; i++) {
            if (arr[map[i]] < K) {
                e = i;
                map[arr[e]]++;
                ans = Math.max(ans, e - s + 1);
            } else {
                while (true) {
                    if (arr[s] == arr[i]) {
                        s++;
                        e = i;
                        break;
                    } else {
                        arr[map[s]]--;
                        s++;
                    }
                }
            }
        }
        System.out.println(ans);


    }
}
