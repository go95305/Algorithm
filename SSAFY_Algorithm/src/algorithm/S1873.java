package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S1873 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\고유창\\git\\javase\\src\\algorithm\\testcase.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] ar = new char[H][W];
			int spx = 0;
			int spy = 0;

			for (int i = 0; i < H; i++) {
				String tmp = sc.next();
				for (int j = 0; j < tmp.length(); j++) {
					ar[i][j] = tmp.charAt(j);
					if (ar[i][j] == '<' || ar[i][j] == '^' || ar[i][j] == '>' || ar[i][j] == 'v') {
						spx = i;
						spy = j;
					}
				}
			}
			int num = sc.nextInt();
			String move = sc.next();
			char[] moving = new char[num];
			for (int i = 0; i < num; i++) {
				moving[i] = move.charAt(i);
			}

			int look = 0;
			if (ar[spx][spy] == '^')
				look = 0;
			else if (ar[spx][spy] == 'v')
				look = 1;
			else if (ar[spx][spy] == '<')
				look = 2;
			else {
				look = 3;
			}
			for (int i = 0; i < num; i++) {
				int nr = 0;
				int nc = 0;
				char tmp = moving[i];
				switch (tmp) {
				case 'U':
					nr = spx - 1;
					if (nr >= 0 && (ar[nr][spy] != '-' && ar[nr][spy] != '*' && ar[nr][spy] != '#')) {
						ar[spx][spy] = '.';
						spx -= 1;
					}
					ar[spx][spy] = '^';
					look = 0;
					break;
				case 'D':
					nr = spx + 1;
					if (nr < H && (ar[nr][spy] != '-' && ar[nr][spy] != '*' && ar[nr][spy] != '#')) {
						ar[spx][spy] = '.';
						spx += 1;
					}
					ar[spx][spy] = 'v';
					look = 1;
					break;
				case 'L':
					nc = spy - 1;
					if (nc >= 0 && (ar[spx][nc] != '-' && ar[spx][nc] != '*' && ar[spx][nc] != '#')) {
						ar[spx][spy] = '.';
						spy -= 1;
					}
					ar[spx][spy] = '<';
					look = 2;
					break;
				case 'R':
					nc = spy + 1;
					if (nc < W && (ar[spx][nc] != '-' && ar[spx][nc] != '*' && ar[spx][nc] != '#')) {
						ar[spx][spy] = '.';
						spy += 1;
					}
					ar[spx][spy] = '>';
					look = 3;
					break;
				case 'S':
					if (look == 0) {
						nr = spx - 1;
						while (nr >= 0 && (ar[nr][spy] != '*' && ar[nr][spy] != '#')) {
							nr -= 1;
						}
						if (nr >= 0 && ar[nr][spy] == '*') {
							ar[nr][spy] = '.';
						}
					} else if (look == 1) {
						nr = spx + 1;
						while (nr < H && (ar[nr][spy] != '*' && ar[nr][spy] != '#')) {
							nr += 1;
						}
						if (nr < H && ar[nr][spy] == '*') {
							ar[nr][spy] = '.';
						}
					} else if (look == 2) {
						nc = spy - 1;
						while (nc >= 0 && (ar[spx][nc] != '*' && ar[spx][nc] != '#')) {
							nc -= 1;
						}
						if (nc >= 0 && ar[spx][nc] == '*') {
							ar[spx][nc] = '.';
						}
					} else {
						nc = spy + 1;
						while (nc < W && (ar[spx][nc] != '*' && ar[spx][nc] != '#')) {
							nc += 1;
						}
						if (nc < W && ar[spx][nc] == '*') {
							ar[spx][nc] = '.';
						}
					}
					break;
				}
			}
			System.out.printf("#%d ", test_case);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(ar[i][j]);
				}
				System.out.println();
			}

		}
	}
}
