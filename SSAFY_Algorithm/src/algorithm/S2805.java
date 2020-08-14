package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S2805 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\고유창\\git\\javase\\src\\algorithm\\testcase.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();// 1
		for (int test_case = 1; test_case <= T; test_case++) {
			int sum = 0;
			int N = sc.nextInt();// 5
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				String[] tmp2 = tmp.split("");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(tmp2[j]);
				}
			}
			
			int rowcnt = 1;// 3,5
			int row = 0;
			for (int i = 0; i <= N / 2; i++) {// 중간까지만 실행//3

				int spY = N / 2;// 2
				spY -= i;// 2,1
				for (int j = 0; j < rowcnt; j++) {
					sum += arr[row][spY];
					spY += 1;
				}
				rowcnt += 2;
				row++;
			}
			
			int leftrowcnt = N - 2;// 3
			for (int i = N / 2 - 1; i >= 0; i--) {// 2
				int spY2 = N / 2;// 2
				spY2 -= i;// 1
				for (int j = leftrowcnt; j > 0; j--) {// 3
					sum += arr[row][spY2];
					spY2 += 1;
				}
				row++;
				leftrowcnt -= 2;
			}
			System.out.printf("#%d %d\n",test_case,sum);
		}
	}

}
