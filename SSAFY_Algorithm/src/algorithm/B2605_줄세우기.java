package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B2605_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ar[] = new int[N];
		for (int i = 0; i < N; i++) {
			int turn = sc.nextInt();
			if (i == 0) {
				ar[i] = (i + 1);
			} else {
				for (int j = i; j > (i - turn); j--) {
					int tmp = ar[j];
					ar[j] = ar[j - 1];
					ar[j - 1] = tmp;
				}
				ar[i-turn] = i + 1;
			}
		}
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]+" ");
		}
	}
}
