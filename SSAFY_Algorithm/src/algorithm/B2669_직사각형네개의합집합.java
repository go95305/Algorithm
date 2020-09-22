package algorithm;

import java.util.Scanner;

public class B2669_직사각형네개의합집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int map[][] = new int[101][101];

		for (int i = 0; i < 4; i++) {
			int lx = sc.nextInt();
			int ly = sc.nextInt();
			int hx = sc.nextInt();
			int hy = sc.nextInt();
			for (int j = lx; j < hx; j++) {
				for (int k = ly; k < hy; k++) {
					map[j][k] = 1;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
