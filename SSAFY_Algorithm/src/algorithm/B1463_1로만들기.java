package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[1000001];
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        int N = Integer.parseInt(br.readLine());
        if (N <= 3) {
            System.out.println(arr[N]);
        } else {
            for (int i = 4; i <= N; i++) {
                int divideByThree = Integer.MAX_VALUE;
                int divideByTwo = Integer.MAX_VALUE;
                int minusOne = Integer.MAX_VALUE;
                if (i % 3 == 0)
                    divideByThree = arr[i / 3] + 1;
                if (i % 2 == 0)
                    divideByTwo = arr[i / 2] + 1;
                minusOne = arr[i - 1] + 1;

                arr[i] = Math.min(divideByThree, Math.min(divideByTwo, minusOne));
            }
            System.out.println(arr[N]);
        }
    }
}
/*
1,2,3은 각각 0,1,1,로 기본값 설정해놓는다.
4부터 bottom-up방식을 상요한다.
각 인덱스는 /3, /2, -1을 한 인덱스에서 가장 최소값으로 갱신한다.

 */