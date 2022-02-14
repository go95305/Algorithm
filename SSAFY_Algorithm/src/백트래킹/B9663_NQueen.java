package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663_NQueen {
    static int N;
    static int map[];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        dfs(0);
        System.out.println(cnt);

    }

    private static void dfs(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {//퀸 특성상 행,열마다 하나씩밖에 못들어가므로 열을 기준으로 for문을 돌면 검색한다.
            map[depth] = i;
            if (isValid(depth)) {
                dfs(depth + 1);
            }
        }


    }

    private static boolean isValid(int col) {
        for (int i = 0; i < col; i++) {
            if (map[i] == map[col]) { // 같은 행
                return false;
            }

            if (Math.abs(col - i) == Math.abs(map[col] - map[i])) {
                return false;
            }
        }
        return true;
    }

    public static class 타일링 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            int ans = 0;
            arr[0] = 1;
            ans = arr[0];
            if (N > 1) {
                arr[1] = 2;
                for (int i = 2; i < N; i++) {
                    arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
                }
                ans = arr[N - 1];
            }
            System.out.println(ans);


        }
    }
}
