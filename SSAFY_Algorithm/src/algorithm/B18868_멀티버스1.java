package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class B18868_멀티버스1 {
	static int same;
	static int M, N;
	static Set<Integer> st = new HashSet<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		int Ans = 0;
		int map[][] = new int[M][N];

		/** 값 입력 */
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		/** 1. cnt배열에 값 넣기 */
		int cnt[] = new int[M];
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

		/**
		 * 2. 0번째 index부터 같은 값이 있는지 확인, 같은 값이 있으면 Set에 넣어서 크기가 3이면 중복 즉, Ans로 count X
		 */
		boolean chk = true;
		for (int i = 0; i < cnt.length; i++) {
			int tmp = cnt[i];
			for (int j = i + 1; j < cnt.length; j++) {
				if (tmp == cnt[j]) {// cnt배열내에 tmp랑 같은 값이 존재하면?->일단 균등한 우주이긴 한데 중복값 확인을 해야한다.
					chk = check(i, j, map);
					if (chk == true) {
						Ans++;
					}
				}
			}
		}
		System.out.println(Ans);
	}

	private static boolean check(int i, int j, int[][] map) {
		int size = st.size();
		for (int k = 0; k < map[i].length; k++) {
			st.add(map[i][k]);
		}
		for (int k = 0; k < map[j].length; k++) {
			st.add(map[j][k]);
		}
		if (size == st.size())
			return false;
		return true;
	}

}
