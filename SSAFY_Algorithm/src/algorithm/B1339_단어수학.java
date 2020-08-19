package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1339_단어수학 {
	static int N;
	static int ar[];
	static boolean v[];
	static int sel[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Character> que = new LinkedList<Character>();
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < tmp.length(); j++) {
				if (!que.contains(tmp.charAt(j))) {
					que.add(tmp.charAt(j));
				}
			}
		}
		ar = new int[26];
		v = new boolean[26];
		sel = new int[26];
//		System.out.println(que);
		int i=0;
		while(!que.isEmpty()){
			char c = que.poll();
			ar[c-'A'] = 9 - i;
			i++;
		}
//		System.out.println(Arrays.toString(ar));
		permutation(0);

	}

	private static void permutation(int k) {
		if (k == sel.length) {
//			System.out.println(Arrays.toString(sel));

			return;
		}
		for (int i = 0; i < ar.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = ar[i];
				permutation(k + 1);
				v[i] = false;
			}
		}
	}

}
