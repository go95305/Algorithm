package algorithm;

import java.util.Scanner;

public class S1952_수영장 {
	static int map[];
	static int price[];
	static int Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			price = new int[4];
			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			map = new int[12];
			for (int i = 0; i < map.length; i++) {
				map[i] = sc.nextInt();
			}
			Ans = price[3];
			dfs(0, 0);
			System.out.printf("#%d %d\n",tc,Ans);
		}
	}

	private static void dfs(int month, int sum) {

		if (month > 11) {
			Ans = Math.min(Ans, sum);
			return;
		}
		if (map[month] == 0) {
			dfs(month + 1, sum);
		}

		dfs(month + 1, map[month] * price[0] + sum);
		dfs(month + 1, price[1] + sum);
		dfs(month + 3, price[2] + sum);

	}
}
