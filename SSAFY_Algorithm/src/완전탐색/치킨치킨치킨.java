package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 치킨치킨치킨 {
    static int N, M;
    static int map[][];
    static int sel[];
    static boolean v[];
    static int arr[];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = i;
        }
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        sel = new int[3];
        combination(0, 0);
        System.out.println(ans);


    }

    private static void combination(int idx, int k) {
        if (k == sel.length) {
            int like = getMaxLike();
            if (ans < like)
                ans = like;
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sel[k] = arr[i];
            combination(idx + 1, k + 1);

        }
    }

    private static int getMaxLike() {
        int sum = 0;
        for (int j = 0; j < N; j++) {
            int cur = 0;
            for (int i = 0; i < sel.length; i++) {
                if (cur < map[j][sel[i]])
                    cur = map[j][sel[i]];
            }
            sum += cur;
        }
        return sum;
    }
}
