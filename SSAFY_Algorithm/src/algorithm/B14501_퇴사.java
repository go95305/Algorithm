package algorithm;

import java.util.Scanner;

public class B14501_퇴사 {
	static int N;
	static int[] T;
	static int[] P;
	static boolean[] v;
	static int sel[];
	static int sum;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N];// 면담 소요일수
		P = new int[N];// 비용
		v = new boolean[N];

		max = 0;// 최대값을 저장

		for (int i = 0; i < N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		powerSet(0, 1, 0);// 부분집합, 1일부터 시작하므로 1을 보낸다.
		System.out.println(max);
	}

	private static void powerSet(int idx, int day, int daysum) {
		if (idx == N) {// 부분집합이 만들어졌을때
			sum = 0;
			for (int i = 0; i < N; i++) {
				if (v[i] == true) {
					if (i + T[i] <= N) {// 현재 날짜에서 소요시간을 더했을때 N일을 넘지않으면,
						sum += P[i];// 비용을 계속 더한다.
						i = i + T[i] - 1;// 소요시간만큼 날짜(시간)을 보낸다.
					}
				}
			}
			if (max < sum) {// 최대값 비교
				max = sum;
			}

			return;

		}
		v[idx] = true;
		powerSet(idx + 1, day + 1, T[idx]);// day를 하루 씩 늘려나간다.
		v[idx] = false;
		powerSet(idx + 1, day + 1, T[idx]);

	}
}
