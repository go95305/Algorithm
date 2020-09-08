package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class J1681_해밀턴순환회로 {

	static int N;
	static int map[][];
	static boolean v[];
	static int sum;
	static int Ans;
	static int last;
	static int start;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];
		v = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Ans = Integer.MAX_VALUE;
//		for (int i = 0; i < N; i++) {
			sum = 0;
			cnt=0;
			start=0;
			dfs(0);
			v = new boolean[N];
//		}
		System.out.println("합계: "+Ans);
	}

	private static void dfs(int x) {
		v[x] = true;
		if (cnt == N - 1) {
			last = x;
			sum+=map[last][0];
			Ans = Math.min(Ans, sum);
			System.out.println("-----------이전정점으로-----------");
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				System.out.println("정점"+(x+1)+"-->"+"정점"+(i+1)+":"+map[x][i]);
				sum += map[x][i];
				cnt++;
				dfs(i);
				cnt--;
				v[x]=false;
//				return;
			}
		}
	}
}
