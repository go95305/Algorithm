package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class B18868_멀티버스1 {
	static int same;
	static int M, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		int Ans = 0;
		int map[][] = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int cnt[] = new int[M];
		int col = 0;
		for (int k = 0; k < M; k++) {
			for (int i = 0; i < N; i++) {
				int comp = map[k][i];
				for (int j = i; j < N; j++) {
					if (comp < map[k][j]) {
						cnt[k]++;
					}
				}
			}
		}
		Set<Integer> st;
		for (int i = 0; i < cnt.length; i++) {
			st=new HashSet<Integer>();
			for (int j = 0; j < N; j++) {
				st.add(map[i][j]);
			}
			System.out.println(st);
			int tmp = cnt[i];
			for (int j = i + 1; j < cnt.length; j++) {
				if (tmp == cnt[j]) {
					for (int k = 0; k < N; k++) {
						st.add(map[j][k]);
					}
					System.out.println(st);
					if (st.size() == N) {
						continue;
					}
					Ans++;
				}
			}
		}
//		System.out.println(Ans);
		System.out.println(Arrays.toString(cnt));
	}

}
