package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B2999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int strlen = str.length();
		int R = 0;
		int C = 0;
		for (int i = 1; i <= strlen; i++) {
			if (strlen % i == 0) {
				R = i;
				C = strlen / R;
				if (i >= (strlen / i)) {
					break;
				}

			}
		}
		String ar[][] = new String[C][R];
		String[] tmp = str.split("");
		int k = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ar[j][i] = tmp[k];
				k++;
			}
		}
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				System.out.print(ar[i][j]);
			}
		}
	}
}
