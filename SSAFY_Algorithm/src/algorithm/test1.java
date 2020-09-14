package algorithm;

import java.util.Stack;

public class test1 {
	public static void main(String[] args) {
		String new_id = "z-+.^.";
		// 1단계
		new_id = new_id.toLowerCase();// 소문자로 치환
		int len = new_id.length();
		for (int i = 0; i < new_id.length(); i++) {
			char tmp = new_id.charAt(i);
			if (tmp - 'a' >= 0 && tmp - 'a' <= 25)
				continue;
			if (((tmp != '-') && (tmp != '_') && (tmp != '.')) && !integerChh(tmp)) {
				new_id = new_id.replace(Character.toString(tmp), "*");
			}
		}

		Stack<Character> st = new Stack<Character>();
		System.out.println(new_id);
		new_id = new_id.replace("*", "");
		System.out.println(new_id);
		for (int i = 0; i < new_id.length(); i++) {
			char tmp = new_id.charAt(i);
			if (st.isEmpty() && tmp == '.') {
				continue;
			} else {
				if (!st.isEmpty() && st.peek() == '.' && tmp == '.')
					continue;
				else
					st.push(tmp);
			}
		}
		
		if (st.size() == 0) {
			st.add('a');
		}
		if(st.get(st.size()-1)=='.') {
			st.pop();
		}
		System.out.println(st);
		System.out.println(st);
		String answer = "";
		if (st.size() >= 16) {
			for (int i = 0; i < 15; i++) {
				if (i == 14) {
					if (st.get(i) == '.')
						continue;
				}
				answer = answer + st.get(i);
			}
		} else if (st.size() <= 2) {
			char tp = st.get(st.size() - 1);
			for (int i = st.size(); i < 3; i++) {
				st.push(tp);
			}
			for (int i = 0; i < st.size(); i++) {
				answer += st.get(i);
			}
		} else {
			for (int i = 0; i < st.size(); i++) {
				answer += st.get(i);
			}
		}

		System.out.println(answer);

	}

	private static boolean integerChh(char tmp) {
		if (tmp == '1' || tmp == '2' || tmp == '3' || tmp == '4' || tmp == '5' || tmp == '6' || tmp == '7' || tmp == '8'
				|| tmp == '9') {
			return true;
		}
		return false;
	}
}
