package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B13545 {
	static int[] ar;
	static int[] sel;
	static boolean[] v;
	static int cnt = 0;
	static int max_cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ar = new int[N];
		v = new boolean[N];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(token.nextToken());
		}
		int query = Integer.parseInt(br.readLine());
		token = new StringTokenizer(br.readLine());
		for (int k = 0; k < query; k++) {
			int i = Integer.parseInt(token.nextToken());
			int j = Integer.parseInt(token.nextToken());
			sel = new int[j - 1 + 1];
			permutation(i, j, 0, 0);
//			System.out.println(cnt);
//			cnt=0;
		}

	}

	private static void permutation(int x, int y, int idx, int k) {
		if (k == y) {
//			for (int l = 1; l < sel.length; l++) {
//				if (ar[l] + ar[l - 1] == 0) {
//					cnt++;
//				}
//			}
//			System.out.println(cnt);
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = 0; i < ar.length; i++) {
			if (i < x - 1) {
				continue;
			}
			
			if (v[i] != true) {
				v[i] = true;
				sel[k] = ar[i];
				permutation(x, y, idx + 1, k + 1);
				v[i] = false;
			}
		}

	}

}
