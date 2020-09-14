package algorithm;

import java.util.Scanner;

public class B1748_수이어쓰기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			int tmp = i;
			while (tmp > 0) {
				tmp = tmp / 10;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
