package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B1592 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\고유창\\git\\javase\\src\\algorithm\\testcase.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		int ar[] = new int[N];// 목표치를 달성하는지를 확인할 배열
		int max = 0;
		int index = 0;
		int cnt = 0;
		ar[index]++;
		while (max != M) {
			if (ar[index] % 2 == 1) {// 홀수 일 경우,오른쪽으로 이동
				index += L;
				if (index >= N) {
					index -= N;
				}
				ar[index]++;
				cnt++;
				if (max < ar[index]) {// 한 사람이 M번 받았는지를 확인
					max = ar[index];
				}
			} else {// 짝수일 경우
				index -= L;
				if (index < 0) {
					index += N;
				}
				ar[index]++;
				cnt++;
				if (max < ar[index]) {
					max = ar[index];
				}
			}
		}
		System.out.println(cnt);

	}
}
