package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S5215_powerset {
	static int score[];
	static int cal[];
	static boolean[] v;
	static int sel[];
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
			sel = new int[N];
			System.out.println("#"+test_case+" "+powerset(0, 0, L));
			max=0;
		}
	}

	private static int powerset(int idx, int k, int limit) {
		if (idx == score.length) {
			int sum_cal = 0;
			int sum_like = 0;
			for (int i = 0; i < score.length; i++) {
				if (v[i] == true) {
//					System.out.print(score[i] + " ");
					sum_cal += cal[i];
					sum_like += score[i];
				}
			}
			if (sum_cal <= limit) {
				if(max<sum_like) {
					max=sum_like;
				}
			}
//			System.out.println();
			return max;
		}
		v[idx] = true;
		powerset(idx + 1, k + 1, limit);
		v[idx] = false;
		powerset(idx + 1, k, limit);
		return max;
	}

}
