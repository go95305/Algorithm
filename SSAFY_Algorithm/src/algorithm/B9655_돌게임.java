package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9655_돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];
        arr[N] = 1;
        int ans = 0;
        int turn = 1;
        for (int i = N; i >= 0; i--) {
            if (i >= 3)
                arr[i - 3] = 1;
            arr[i - 1] = 1;

            if (arr[0] == 1)
                break;
            turn = -(turn);
        }

        if (turn == 1)
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}
