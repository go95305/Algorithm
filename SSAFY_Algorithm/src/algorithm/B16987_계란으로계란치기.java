package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B16987_계란으로계란치기 {
	static int Ans;
	static int N;
	static boolean flag;

	static class egg {
		int life, weight;

		@Override
		public String toString() {
			return "egg [life=" + life + ", weight=" + weight + "]";
		}

		egg(int life, int weight) {
			this.life = life;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ArrayList<egg> list = new ArrayList<egg>();
		for (int i = 0; i < N; i++) {
			list.add(new egg(sc.nextInt(), sc.nextInt()));
		}

		Ans = 0;
		dfs(0, list, 0);
		System.out.println(Ans);

	}

	private static void dfs(int idx, ArrayList<egg> list, int cnt) {
		if (idx == N) {
			Ans = Math.max(Ans, cnt);
			return;
		}
		if (list.get(idx).life <= 0) {
			dfs(idx + 1, list, cnt);
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			int tmp = 0;
			if (idx == i)
				continue;

			if (list.get(i).life > 0) {
				list.get(idx).life -= list.get(i).weight;
				if (list.get(idx).life <= 0)
					tmp++;
				list.get(i).life -= list.get(idx).weight;
				if (list.get(i).life <= 0)
					tmp++;
				dfs(idx + 1, list, cnt + tmp);
				list.get(idx).life += list.get(i).weight;
				list.get(i).life += list.get(idx).weight;
			}
		}
		Ans=Math.max(Ans, cnt);
	}
}
