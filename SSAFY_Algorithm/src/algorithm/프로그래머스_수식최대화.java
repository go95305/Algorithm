package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class 프로그래머스_수식최대화 {
	static boolean v[];
	static Stack<Character> stm = new Stack<Character>();
	static Stack<Character> st = new Stack<Character>();
	static String sel[];

	static String ar[] = {  "+", "-" ,"*"};

	static long answer;

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";

		char[] c = expression.toCharArray();
		for (int i = 0; i < c.length; i++) {
			st.push(c[i]);
		}

		ArrayList<String> list = new ArrayList<String>();
		String tmp = "";
		while (!st.isEmpty()) {
			char tmpc = st.pop();
			if (tmpc == '-' || tmpc == '*' || tmpc == '+') {
				list.add(tmp);
				list.add(Character.toString(tmpc));
				tmp = "";
			} else {
				tmp = tmpc + tmp;
			}
			if (st.size() == 0) {
				list.add(tmp);
			}
		}
		answer = 0;
		v = new boolean[3];
		sel = new String[3];
		permutation(0, 0, list);
		System.out.println(answer);
	}

	private static void permutation(int idx, int k, ArrayList<String> list) {
		if (k == ar.length) {
			long calc = 0;
			System.out.println(Arrays.toString(sel));
			System.out.println(list);
			ArrayList<String> copy = new ArrayList<>(list);
			for (int j = 0; j < sel.length; j++) {
				String tmp = sel[j];// -가 들어간다.
				for (int i = copy.size()-1; i >=0; i--) {
					if (copy.get(i).equals(tmp)) {// -가 나오면
						long a =Long.parseLong(copy.get(i - 1));

						long b = Long.parseLong(copy.get(i + 1));

						switch (tmp) {
						case "-":
							calc = calc + (b - a);
							break;
						case "+":
							calc = calc + (b + a);
							break;
						case "*":
							calc = calc + (b * a);
							break;
						}
						copy.remove(i);// -를 뺀다.
						copy.remove(i);
						copy.set(i - 1, Long.toString(calc));
						System.out.println(copy);
					}
					calc = 0;
				}
			}
			long num=Math.abs(Long.parseLong(copy.get(0)));
			answer = Math.max(answer,num);
			System.out.println("===========");
			return;
		}
		for (int i = 0; i < ar.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = ar[i];
				permutation(i + 1, k + 1, list);
				v[i] = false;
			}
		}
	}
}
