package algorithm;

import java.util.Scanner;

public class B1074_Z {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int y = (int) Math.pow(2, N) / 2;
		int x = y;

		while (N-- > 0) {
			int temp = (int) Math.pow(2, N) / 2;
			int skip = (int) Math.pow(4, N);
			
			if(r<y && c<x) {
				x-=temp;
				y-=temp;
			}
		}
	}

}