package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 탑 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans[] = new int[N];
        for (int i = 1; i < N; i++) {
            int top = arr[i];
            int idx = i - 1;

            if (top <= arr[idx]) { // 왼쪽게 더 크면
                ans[i] = idx+1;
            } else {// 왼쪽게 더 작으면 왼쪽이 바라보는 탑이랑 같을것이다.
                int val = ans[i - 1]-1;
                while (val >= 0) {

                    if (arr[val] < top) {
                        val = ans[val]-1;
                    } else {
                        ans[i] = val+1;
                        break;
                    }
                }
            }

//arr 4 2 1 3
//ans 0 1 2 1
        }
        for (int i = 0; i < ans.length; i++) {
            if (i == ans.length - 1)
                System.out.print(ans[i]);
            else
                System.out.print(ans[i] + " ");
        }
    }
}
