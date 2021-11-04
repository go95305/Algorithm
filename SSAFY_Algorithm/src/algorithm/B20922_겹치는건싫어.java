package algorithm;

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

        int s = N / 2;
        int e = s + 1;
        int arr[] = new int[100001];
        int ans = 0;
        arr[map[s]]++;
        arr[map[e]]++;
        if (arr[map[s]] > K || arr[map[e]] > K) {
            System.out.println(1);
        } else {
            s--;
            e++;
            int turn = 1;
            /*s가 이동할경우*/
            while (true) {
                if (turn == 1) {
                    //오른쪽이동하다가 K초과했거나 맨끝에 도달하면
                    if (e == N || arr[map[e]] + 1 > K) {
                        turn = -1;
                        e--;
                    } else {
                        arr[map[e]]++;
                        e++;
                    }
                } else {//왼쪽이동
                    if (s == -1 || arr[map[s]] + 1 > K) {
                        s++;
                        break;
                    } else {
                        arr[map[s]]++;
                        s--;
                    }
                }
            }
            ans = Math.max(ans, (e - s) + 1);

            while (true) {
                if (turn == 1) {
                    //오른쪽이동하다가 K초과했거나 맨끝에 도달하면
                    if (e == N || arr[map[e]] + 1 > K) {
                        turn = -1;
                        e--;
                    } else {
                        arr[map[e]]++;
                        e++;
                    }
                } else {//왼쪽이동
                    if (s == -1 || arr[map[s]] + 1 > K) {
                        s++;
                        break;
                    } else {
                        arr[map[s]]++;
                        s--;
                    }
                }
            }
            ans = Math.max(ans, (e - s) + 1);
        }


    }
}
