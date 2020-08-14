package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B8320 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\고유창\\git\\javase\\src\\algorithm\\testcase.txt"));
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = 0;
		boolean[][] chk = new boolean[num][num];
		for (int i = 1; i <= num; i++) {// 1~6까지 실행
			int row = i;// 행은 i
			for (int j = 1; j <= (num / row); j++) {// 1행일 경우 6번, 2행일 겅여 3번실행
				if (chk[j - 1][row - 1] == false) {
					chk[row - 1][j - 1] = true;
					cnt++;
					System.out.println(row + "*" + j + "=" + cnt);
				}
			}
		}

	}

}
