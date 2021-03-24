package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12886_돌그룹 {
    static int map[];
    static boolean v[][];
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < map.length; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        sum = map[0] + map[1] + map[2];
        v = new boolean[1501][1501];
        dfs(map[0], map[1]);
        if (!v[sum / 3][sum / 3])
            System.out.println(0);
        else if (sum % 3 != 0)
            System.out.println(0);
        else
            System.out.println(1);
    }

    private static void dfs(int x, int y) {
        if (v[x][y])
            return;
        v[x][y] = true;
        int a[] = {x, y, sum - x - y};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int b[] = {x, y, sum - x - y};
                    b[i] += a[i];
                    b[j] -= a[i];
                    dfs(b[0], b[1]);
                }
            }
        }
    }


}
