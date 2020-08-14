package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15656 {
	static int[] ar;
	static int[] sel;
	static boolean[] v;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		ar = new int[N];
		sel = new int[M];
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(ar);
		v = new boolean[N];
		permutation(0, 0, N, M, v);
		bw.flush();
//		bw.close();
	}

	private static void permutation(int idx, int k, int n, int m, boolean[] v) throws IOException {
		if (k == m) {
			for (int i = 0; i < sel.length; i++) {
				bw.write(sel[i] + " ");
			}
			bw.newLine();
			return;
		}
		for (int i = 0; i < n; i++) {
				sel[k] = ar[i];
				permutation(i + 1, k + 1, n, m, v);
		}
	}
}
