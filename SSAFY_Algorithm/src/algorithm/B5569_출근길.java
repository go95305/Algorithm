package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5569_출근길 {
    static int W, H;
    static int DP[][][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        DP = new int[100][100][2][2];
        for (int i = 0; i < W; i++) {
            DP[i][0][0][1] = 1;
        }
        for (int i = 0; i < H; i++) {
            DP[0][i][1][1] = 1;
        }

        //3번째 인덱스: 0 -> 북 1 -> 동
        //4번째 인덱스: 회전 여부(1가능 0불가능)
        for (int i = 1; i < W; i++) {
            for (int j = 1; j < H; j++) {
                DP[i][j][0][0] = DP[i - 1][j][1][1]; // 북으로 왔고 회전이 불가능 -> 이전에서 동에서 회전이 가능한상태에서 옴
                DP[i][j][0][1] = DP[i - 1][j][0][1] + DP[i - 1][j][0][0];//북으로 왔고 회전이 가능 하므로 -> 이전에도 북에서 이동했거나 이전에도 동인데 회전이 불가능한 상태에서 옴.
                DP[i][j][1][0] = DP[i][j - 1][0][1]; //동으로 왔고 회전이 불가능 하므로 -> 이전에는 북에서 왔고 그 당시에는 회전이 가능했다.
                DP[i][j][1][1] = DP[i][j - 1][1][0] + DP[i][j - 1][1][1];//동으로 왔고 회전이 가능 하므로 -> 이전에도 동이면서 회전이 불가능하거나 북이였는데 회전이 불가능상태.
            }
        }
        int sum = (DP[W - 1][H - 1][0][0] + DP[W - 1][H - 1][0][1] + DP[W - 1][H - 1][1][0] + DP[W - 1][H - 1][1][1]) % 100000;
        System.out.println(sum);

    }
}

