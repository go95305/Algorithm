package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class S5432_쇠막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;
			char bef = 0;
			String stick = sc.next();
			Stack<Character> st = new Stack<Character>();
			for (int i = 0; i < stick.length(); i++) {
				char tmp = stick.charAt(i);
				if (tmp == ')') {
					if (bef == '(') {
						st.pop();
						ans += st.size();
					} else {
						st.pop();
						ans++;
					}
				} else {
					st.push(tmp);
				}
				bef = tmp;
			}
			System.out.printf("#%d %d\n", test_case, ans);
		}
	}
}
