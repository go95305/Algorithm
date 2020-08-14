package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B14888 {
	static int math[];
	static char math2[];
	static long max = Long.MIN_VALUE; // 계산 결과가 음수일 수도 있기때문에
	static long min = Long.MAX_VALUE;
	static int ar[];
	static char sel[];
	static boolean[] v;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		math = new int[4];// 총 연산자 개수는 4개
		ar = new int[N];
		for (int i = 0; i < N; i++) {
			ar[i] = sc.nextInt();
		}
		for (int i = 0; i < math.length; i++) {// math배열에 연산자의 개수를 입력받는다.
			int tp = sc.nextInt();
			math[i] = tp;
			cnt += tp;
		}
		math2 = new char[cnt];
		sel = new char[cnt];
		v = new boolean[cnt];
		int p = 0;
		for (int i = 0; i < 4; i++) {// math2배열에 math배열의 각 index개수만큼 char형으로 연산자를 넣어준다.
			int tmp = math[i];
			if (i == 0) {
				for (int j = 0; j < tmp; j++) {// ex) tmp가 2일 경우 '+'를 두번 넣어준다.
					math2[p] = '+';
					p++;
				}
			} else if (i == 1) {
				for (int j = 0; j < tmp; j++) {
					math2[p] = '-';
					p++;
				}
			} else if (i == 2) {
				for (int j = 0; j < tmp; j++) {
					math2[p] = '*';
					p++;
				}
			} else {
				for (int j = 0; j < tmp; j++) {
					math2[p] = '/';
					p++;
				}
			}
		}

		permutation(0, 0);
		System.out.println(max);
		System.out.println(min);

	}

	private static void permutation(int idx, int k) {
		if (k == sel.length) {
			int p = 0;
			int sum = ar[p];// 초기값은 수열 의 첫재값, 0으로 초기화 해서 시작하면 연산이 덜된다.
			p++;
			for (int i = 0; i < math2.length; i++) {
				char tmp = sel[i];
				switch (tmp) {
				case '+':// 덧셈
					sum += ar[p];
					p++;
					break;
				case '-':
					sum -= ar[p];
					p++;
					break;
				case '*':
					sum *= ar[p];
					p++;
					break;
				case '/':
					sum /= ar[p];
					p++;
					break;
				}
			}
			if (max < sum) {//최대값 구하기
				max = sum;
			}
			if (min > sum) {//최소값 구하기
				min = sum;
			}

			return;
		}
		for (int i = 0; i < math2.length; i++) {
			if (v[i] != true) {
				v[i] = true;
				sel[k] = math2[i];
				permutation(idx + 1, k + 1);
				v[i] = false;
			}
		}
	}
}
