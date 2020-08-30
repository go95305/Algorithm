package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class B2617_구슬찾기 {
	static int N, M;
	static ArrayList<Integer>[] big;
	static ArrayList<Integer>[] small;
	static boolean v[][];
	static int Ans;
	static int bCnt;
	static int sCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int baseNum = (N + 1) / 2;
		big = new ArrayList[N + 1];
		small = new ArrayList[N + 1];
		Ans = 0;
		for (int i = 0; i < big.length; i++) {
			big[i] = new ArrayList<Integer>();
			small[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			big[to].add(from);
			small[from].add(to);
		}

		for (int i = 1; i <= N; i++) {
			v = new boolean[2][N + 1];
			bCnt = 0;
			sCnt = 0;
			dfsb(i);
			dfss(i);
			if (bCnt >= baseNum || sCnt >= baseNum) {
				Ans++;
			}
		}
		System.out.println(Ans);

	}

	private static void dfss(int idx) {
		v[0][idx] = true;
		int size = small[idx].size();
		for (int i = 0; i < size; i++) {
			Integer n = small[idx].get(i);
			if (!v[0][n]) {
				sCnt++;
				dfss(n);
			}
		}
	}

	private static void dfsb(int idx) {
		v[1][idx] = true;
		int size = big[idx].size();
		for (int i = 0; i < size; i++) {
			Integer n = big[idx].get(i);
			if (!v[1][n]) {
				bCnt++;
				dfsb(n);
			}
		}
	}

}
