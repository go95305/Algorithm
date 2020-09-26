package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class B8958_OX퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			Stack<Character> st = new Stack();
			String tmp = sc.next();
			for (int j = 0; j < tmp.length(); j++) {
				st.push(tmp.charAt(j));
			}

			int cnt = 0;
			int sum = 0;
			while (!st.isEmpty()) {
				char alp = st.pop();
				if (alp == 'O') {
					cnt += 1;
					sum += cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(sum);
		}
	}
}
