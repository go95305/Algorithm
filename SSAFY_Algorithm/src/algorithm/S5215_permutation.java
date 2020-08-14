package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S5215_permutation {
	static int score[];
	static int cal[];
	static boolean[] v;
	static int selc[];
	static int selL[];
	static int max = 0;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\multicampus\\git\\algorithm\\Algorithm\\src\\testcase.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			score = new int[N];
			cal = new int[N];
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			v = new boolean[N];
			selL = new int[N];
			selc = new int[N];

			System.out.println("#" + test_case + " " + permutation(0, 0, L));
			max=0;
		}
	}

	private static int permutation(int idx, int k, int limit) {
		if (k == selc.length) {
			int sum_like = 0;
			int sum = 0;
			int a=0;
			while(sum<limit) {
				sum+=selc[a];
				a++;
			}
			if(sum>limit) {
				sum-=selc[a-1];
			}
			for(int i=0;i<a-1;i++) {
				sum_like+=selL[i];
			}

			if(max<sum_like) {
				max=sum_like;
			}
			return max;
		}
		for (int i = 0; i < score.length; i++) {
			if (v[i] != true) {
				v[i] = true;
				selL[k] = score[i];
				selc[k] = cal[i];
				permutation(i + 1, k + 1, limit);
				v[i] = false;
			}
		}
		return max;
	}

}
