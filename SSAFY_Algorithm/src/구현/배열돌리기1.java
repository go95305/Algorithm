package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1 {
    static int N, M, R;
    static int arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int min = Math.min(N, M);
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int k = 0; k < R; k++) {
            for (int i = 0; i < min / 2; i++) {
                rotateArray(i);
//                System.out.println("배열 바뀜");
//                print(arr);
            }
        }

        print(arr);
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void rotateArray(int idx) {
        int val = arr[idx][idx];
        for (int i = idx + 1; i < M - idx; i++) {
            arr[idx][i - 1] = arr[idx][i];
        }
        for (int i = idx + 1; i < N - idx; i++) {
            arr[i - 1][M - idx - 1] = arr[i][M - idx - 1];
        }
        for (int i = M - 2 - idx; i >= idx; i--) {
            arr[N - idx - 1][i + 1] = arr[N - idx - 1][i];
        }
        for (int i = N - 2 - idx; i >= idx; i--) {
            arr[i + 1][idx] = arr[i][idx];
        }
        arr[idx + 1][idx] = val;
    }
}
