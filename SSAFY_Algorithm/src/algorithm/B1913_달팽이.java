package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B1913_달팽이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int map[][] = new int[N][N];
        int r = N / 2;
        int c = r;

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        int idx = 1;
        int x = 0;
        int y = 0;
        map[r][c] = idx++;
        int k = 0;//숫자가 넣어지는 방향
        //outer for문은 N번 실행
        for (int i = 1; i <= N; i++) {
            if (i < N) {
                for (int m = 0; m < 2; m++) { //매 idx마다 두번씩 돈다.
                    for (int j = 0; j < i; j++) { //i칸만큼만 이동
                        r = r + dr[k];
                        c = c + dc[k];
                        map[r][c] = idx++;
                        if (map[r][c] == K) {
                            x = r + 1;
                            y = c + 1;
                        }
                    }
                    k++;
                    if (k == 4)
                        k = 0;
                }
            } else {
                for (int j = 0; j < N - 1; j++) {
                    r = r + dr[k];
                    c = c + dc[k];
                    map[r][c] = idx++;
                    if (map[r][c] == K) {
                        x = r + 1;
                        y = c + 1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(x + " " + y);
    }
}
