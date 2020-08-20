package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1339_단어수학 {
	static int N;
	static int ar[];
	static boolean v[];
	static int sel[];
	static String tmp[];
	static int max;
	static int[] arr;
	static int p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		tmp = new String[11];
		arr = new int[26];

		p = 1;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			tmp[i] = st.nextToken();
			for (int j = 0; j < tmp[i].length(); j++) {
				if (arr[tmp[i].charAt(j) - 'A'] == 0) {
					arr[tmp[i].charAt(j) - 'A'] = p;
					p++;
				}
			}
		}

//		System.out.println(p);
		ar = new int[11];
		v = new boolean[10];
		sel = new int[11];
//		System.out.println(Arrays.toString(arr));
//		System.out.println(set);
//		for (int i = 0; i < ar.length; i++) {
//			ar[i] = 9 - i;
//		}
//		System.out.println(Arrays.toString(ar));
		max = 0;
		permutation(1);
		System.out.println(max);

	}

	private static void permutation(int k) {
		if (k == p) {

			String tp = "";
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < tmp[i].length(); j++) {
					tp += sel[arr[tmp[i].charAt(j) - 'A']];
				}

				ans += Integer.parseInt(tp);
				tp = "";
			}
			if (max < ans) {
				max = ans;
			}
			return;
		}
		for (int i = 9; i >= 0; i--) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = i;
				permutation(k + 1);
				v[i] = false;
			}
		}
	}

}
