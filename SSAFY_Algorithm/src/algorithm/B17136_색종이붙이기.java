package algorithm;

import java.util.Scanner;

public class B17136_색종이붙이기 {
	static int map[][];
	static boolean v[][][];
	static int Ans, totalPaper;
	static boolean flag;
	static int cntArr[];
	static int cnt;
	static int one;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][10];
//		v = new boolean[6][10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
				one++;
			}
		}
		Ans = Integer.MAX_VALUE;
		cntArr = new int[6];
		totalPaper = 0;
		cnt = 5;
		while (cnt > 0) {
			flag = true;
			v = new boolean[6][10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (map[i][j] == 1 && !v[cnt][i][j] && i + cnt <= 10 && j + cnt <= 10) {
						dfs(i, j, cnt);
					}
				}
			}
//			System.out.println(totalPaper);
			for(int i=0;i<cntArr.length;i++) {
				System.out.print(cntArr[i]+" ");
			}
			System.out.println();
//			for (int i = 0; i < cntArr.length; i++) {
//				if (cntArr[i] >= 5) {
//					flag = false;
//				}
//			}
//			if (flag) {
//				Ans=Math.min(Ans,totalPaper);
//			}
			cntArr = new int[6];

//			chk();
//			if (flag) {
//				Ans = Math.min(Ans, totalPaper);
//			}
			totalPaper = 0;
			cnt--;
		}

//		System.out.println(Ans);

	}

	private static void chk() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					flag = false;
					break;
				}
			}
			if (!flag)
				break;
		}
		for (int i = 1; i < cntArr.length; i++) {
			if (cntArr[i] > 5) {
				flag = false;
				break;
			}
		}

	}

	private static void dfs(int x, int y, int count) {
		for (int i = x; i < x + count; i++) {
			for (int j = y; j < y + count; j++) {
				if (map[i][j] == 0) {
					dfs(x, y, count - 1);
					return;
				}
			}
		}
		for (int i = x; i < x + count; i++) {
			for (int j = y; j < y + count; j++) {
				v[cnt][i][j] = true;
			}
		}
		cntArr[count]++;
		totalPaper++;
	}

}
