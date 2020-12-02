package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S2814_최장경로 {
	static int N, M;
	static int Ans;
	static ArrayList<Integer> adj[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 정점수
			M = Integer.parseInt(st.nextToken());// 간선수
			adj = new ArrayList[N + 1];

			for (int i = 0; i < N + 1; i++) {
				adj[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
				adj[to].add(from);
			}

			for (int i = 0; i < adj.length; i++) {
				dfs(i, 1, new boolean[N + 1]);
			}

			System.out.printf("#%d %d\n", tc, Ans);
		}
	}

	private static void dfs(int idx, int cnt, boolean[] v) {
		v[idx] = true;
		int size = adj[idx].size();
		for (int i = 0; i < size; i++) {
			Integer n = adj[idx].get(i);
			if (!v[n]) {
				dfs(n, cnt + 1, v);
				v[n] = false;
			}
		}
		v[idx] = false;
		Ans = Math.max(Ans, cnt);
	}
}
