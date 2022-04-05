package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 마인크래프트 {
    static int N, M, B;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = Integer.MAX_VALUE;
        int target = 0;
        for (int h = 0; h <= 256; h++) {
            int stack = 0;
            int tear = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int height = map[i][j] - h;
                    if (height > 0)
                        tear += height; // 인벤토리 저장용은 무조건 양수
                    else if (height < 0)
                        stack -= height; //쌓을 것은 무조건 음수
                }
            }

            //제거한 블록과 인벤토리를 합쳐서 해당 h에 맞게 쌓을 수 있는 개수가 충족되면
            if (tear + B >= stack) {
                int time = tear * 2 + stack;
                if (ans >= time) {
                    ans = time;
                    target = h;
                }
            }
        }
        System.out.println(ans + " " + target);
    }
}
