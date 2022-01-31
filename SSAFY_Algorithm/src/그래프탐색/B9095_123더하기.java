package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095_123더하기 {
    static int N;
    static int arr[];
    static boolean v[];
    static int cnt;
    static int math[] = {1, 2, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            cnt = 0;
            N = Integer.parseInt(br.readLine());
            getCnt(0);
            System.out.println(cnt);
        }
    }

    private static void getCnt(int cur) {
        if (cur==N){
            cnt++;
            return;
        }

        if (cur+1<=N){
            getCnt(cur+1);
        }
        if (cur+2 <= N){
            getCnt(cur+2);
        }
        if (cur+3<=N){
            getCnt(cur+3);
        }

    }


}
