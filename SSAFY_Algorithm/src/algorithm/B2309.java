package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B2309 {
	// 조합: 9명 중 7명의 조합을 구하고나서 키의 합이 100이면 출력
	static int[] ar= new int[9];
	static int[] sel = new int[7];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<9;i++) {
			ar[i]=sc.nextInt();
		}
		combination(0, 0);
	}

	private static void combination(int idx, int k) {
		if (k == sel.length) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if (sum == 100) {
					Arrays.sort(sel);
					for(int i=0;i<sel.length;i++) {
						System.out.println(sel[i]);
					}
				return;
			}
			return;
		}
		for(int i=idx;i<ar.length;i++) {
			sel[k]=ar[i];
			combination(i+1, k+1);
		}
	}

}
