package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B2564_경비원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int col = sc.nextInt();
		int row = sc.nextInt();
		int N = sc.nextInt();
		int map[][] = new int[N][2];
		for (int i = 0; i < N; i++) {// 가게의 위치를 저장
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
		}

		int userDir = sc.nextInt();// 동근이
		int userLen = sc.nextInt();// 동근이
		int sum = 0;
		switch (userDir) {
		case 1:// ok
			for (int i = 0; i < N; i++) {
				if (map[i][0] == 1) {
					sum += Math.abs(userLen - map[i][1]);
				} else if (map[i][0] == 2) {
					sum += Math.min(userLen + row + map[i][1], (col - userLen) + row + (col - map[i][1]));
				} else if (map[i][0] == 3) {
					sum += Math.min(userLen + map[i][1], (col - userLen) + row + col + (col - map[i][1]));
				} else {
					sum += Math.min((col - userLen) + map[i][1], userLen + row + col + (row - map[i][1]));
				}
			}
			break;
		case 2:// ok
			for (int i = 0; i < N; i++) {
				if (map[i][0] == 1) {
					sum += Math.min(userLen + row + map[i][1], (col - userLen) + row + (col - map[i][1]));
				} else if (map[i][0] == 2) {
					sum += Math.abs(userLen - map[i][1]);
				} else if (map[i][0] == 3) {
					sum += Math.min(userLen + (row - map[i][1]), (col - userLen) + row + col + (row - map[i][1]));
				} else {
					sum += Math.min((col - userLen) + (row - map[i][1]), userLen + row + col + (row - map[i][1]));
				}
			}
			break;
		case 3:// ok
			for (int i = 0; i < N; i++) {
				if (map[i][0] == 1) {
					sum += Math.min(userLen + map[i][1], (row - userLen) + col + row + (col - map[i][1]));
				} else if (map[i][0] == 2) {
					sum += Math.min((row - userLen) + map[i][1], userLen + col + row + (col - map[i][1]));
				} else if (map[i][0] == 3) {
					sum += Math.abs(userLen - map[i][1]);
				} else {
					sum += Math.min(userLen + col + map[i][1], (row - userLen) + col + (col - map[i][1]));
				}
			}
			break;
		case 4:
			for (int i = 0; i < N; i++) {
				if (map[i][0] == 1) {
					sum += Math.min(userLen + (col - map[i][1]), (row - userLen) + col + row + map[i][1]);
				} else if (map[i][0] == 2) {
					sum += Math.min((row - userLen) + (col - map[i][1]), userLen + col + row + (col - map[i][1]));
				} else if (map[i][0] == 3) {
					sum += Math.min(userLen + col + map[i][1], (row - userLen) + col + (row - map[i][1]));
				} else {
					sum += Math.abs(userLen - map[i][1]);
				}
			}
			break;
		}
		System.out.println(sum);

	}
}
