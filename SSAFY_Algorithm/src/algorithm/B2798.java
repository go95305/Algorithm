package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int card = sc.nextInt();
		int goalNum = sc.nextInt();

		int[] ar = new int[card];
		int[] ans = new int[card];
		for (int i = 0; i < card; i++) {
			ar[i] = sc.nextInt();
		}
		Arrays.sort(ar);
		int max = 0;
		for (int i = 0; i < ar.length; i++) {
			int sum=0;
			sum += ar[i];
			for (int j = i + 1; j < ar.length; j++) {
				if (sum + ar[j] > goalNum) {
					continue;
				} else {
					sum += ar[j];
				}
				for (int k = j + 1; k < ar.length; k++) {
					if (sum + ar[k] <= goalNum) {
						if(sum+ar[k]>max ) {
							max=sum+ar[k];
						}
					}
				}
				sum-=ar[j];
			}
		}
		System.out.println(max);
	}
}
