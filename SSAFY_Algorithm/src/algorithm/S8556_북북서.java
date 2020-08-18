package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class S8556_북북서 {
	static double ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			ans = 0;
			Stack<Character> st = new Stack();
			String str = sc.next();
			if (str.contains("north")) {
				str = str.replaceAll("north", "*");
			}
			if (str.contains("west")) {
				str = str.replaceAll("west", "-");
			}

			for (int i = 0; i < str.length(); i++) {
				st.add(str.charAt(i));
			}

			int j = 0;// 제곱 계산에 사용
			double tp = 0;// 현재 값에 더할(뺄)값
			int k = 1;// 나중에 정답에 붙일 /k 형의 값
			while (!st.isEmpty()) {// 스택에서 하나씩 꺼내면서 계산
				char tmp = st.pop();
				if (j == 0) {// 초기값 설정
					if (tmp == '*') {
						ans = 0;
					} else {
						ans = 90;
					}
				} else {
					tp = 90 / Math.pow(2, j);
					if (tmp == '*') {// north일경우
						ans -= tp;// 현재 값에서 빼준다.

					} else {// west일경우
						ans += tp;// 현재 값에서 더해준다.
					}
				}
				j++;
			}

			boolean flag = true;
			while (flag) {
				if (ans == (int) ans) {// 정수형이랑 실수형태랑 다르면 계속 진행
					flag = false;
				} else {
					ans *= 2;// 2씩 계속 곱해준다.
					k *= 2;
				}
			}

			if (k != 1) {// 결과값이 정수형태가 아니였으면
				System.out.printf("#%d %s\n", test_case, (int) ans + "/" + k);
			} else {// 결과값이 실수형태가 아니였으면
				System.out.printf("#%d %d\n", test_case, (int) ans);
			}
		}
	}
}
