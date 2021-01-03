package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_삼각달팽이 {
    public static void main(String[] args) {
        int[] answer = {};
        int n = 6;
        int B[][] = new int[n][n];
        int r[] = {0, 1, -1};
        int c[] = {1, 0, -1};
        int x = 0;
        int y = 0;
        int cnt = 2;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (i == 0 && j == 1) {
                    B[0][0] = 1;
                } else {
                    x = x + r[idx];
                    y = y + c[idx];
                    B[x][y] = cnt;
                    cnt++;
                }
            }
            idx++;
            if (idx == 3) {
                idx = 0;
            }
        }
        cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                que.add(B[j][i]);
            }
        }
        answer = new int[que.size()];
        while(!que.isEmpty()){
            answer[cnt]=que.poll();
            cnt++;
        }

        System.out.println(Arrays.toString(answer));
    }
}
