package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630_색종이만들기_re {
    static int N;
    static int map[][];
    static int whiteCnt;
    static int blueCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        whiteCnt = 0;
        blueCnt = 0;
        Divide(0, 0, N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);

    }

    private static void Divide(int r, int c, int size) {
        //범위 전체가 1혹은0으로 구성됬는지 확인
        int white = 0;
        int blue = 0;
        boolean flag = true;
        go:
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] == 0)
                    white++;
                else
                    blue++;

                if (white > 0 && blue > 0) {
                    flag = false;
                    break go;
                }
            }
        }
        //하나로 전부 구성됬으면 1,0에 따라 블랙,화이트로 카운트 증가
        if (flag) {
            if (white == 0)
                blueCnt++;
            else if (blue == 0)
                whiteCnt++;
        } else {
            //만약 아니면 더 나눈다.
            Divide(r, c, size / 2);
            Divide(r, c + size / 2, size / 2);
            Divide(r + size / 2, c, size / 2);
            Divide(r + size / 2, c + size / 2, size / 2);
        }

    }
}
