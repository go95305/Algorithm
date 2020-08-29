package algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B15686_치킨배달 {
	static class Loc {
		int r, c;

		Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static ArrayList<Loc> home = new ArrayList<Loc>();
	static ArrayList<Loc> chicken = new ArrayList<Loc>();
	static int N, M;
	static int Ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int n = sc.nextInt();
				if (n == 1) {
					home.add(new Loc(r, c));
				} else if (n == 2) {
					chicken.add(new Loc(r, c));
				}
			}
		}
		v = new boolean[chicken.size()];
		sel = new int[M];

		com(0, 0);
		System.out.println(Ans);

		sc.close();
	}

	static int[] sel;
	static boolean[] v;

	private static void com(int idx, int k) {
		if (k == M) {
			int sum = 0;
			for (int i = 0; i < home.size(); i++) {
				int dist = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					dist = Math.min(dist, calc(home.get(i), chicken.get(sel[j])));

				}
				sum += dist;
			}
			Ans = Math.min(Ans, sum);
			return;
		}
//		if (idx == chicken.size()) {
//			return;
//		}
//		sel[k] = idx;
//		com(idx + 1, k + 1);
//		com(idx + 1, k);

		for (int i = idx; i < chicken.size(); i++) {
			if(!v[i]) {
				v[i]=true;
				sel[k]=i;
				com(i+1, k+1);
				v[i]=false;
			}
		}

	}

	private static int calc(Loc loc, Loc loc2) {
		return Math.abs(loc.r - loc2.r) + Math.abs(loc.c - loc2.c);
	}

}
