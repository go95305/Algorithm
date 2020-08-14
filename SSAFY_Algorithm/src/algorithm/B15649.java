package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B15649 {
	static int[] ar;
	static int[] sel;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ar = new int[N];
		sel = new int[M];
		for (int i = 0; i < N; i++) {
			ar[i] = i + 1;// 1~3d의 값이 들어간다.
		}
		permutation(0, 0, N, M);
		bw.flush();
//		bw.close();
	}

	private static void permutation(int idx, int k, int n, int m) throws IOException {
		if (k == m) {
			for (int i = 0; i < sel.length; i++) {
				bw.write(sel[i] + " ");
			}
			bw.newLine();
			return;
		}
		for (int i = 0; i < n; i++) {
			sel[k] = ar[i];
			permutation(idx + 1, k + 1, n, m);
		}
	}
}
