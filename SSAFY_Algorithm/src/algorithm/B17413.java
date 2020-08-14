package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class B17413 {
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("C:\\Users\\고유창\\git\\javase\\src\\algorithm\\testcase.txt"));
		Scanner sc = new Scanner(System.in);

//		for (int tc = 0; tc < 7; tc++) {
			Stack<Character> st = new Stack();
			String str = sc.nextLine();

			StringBuilder sb = new StringBuilder();
			String mun = "";
			char tmp = str.charAt(0);
			int i = 0;
			while (i < str.length()) {
				if (tmp == '<') {
					sb.append(tmp);
					i++;

					tmp = str.charAt(i);

					while (tmp != '>') {
						sb.append(tmp);
						i++;
						tmp = str.charAt(i);
					}
					sb.append(tmp);
					i++;
					if (i < str.length()) {
						tmp = str.charAt(i);
					}
				} else if (tmp == ' ') {
					sb.append(tmp);
					i++;
					if (i < str.length()) {
						tmp = str.charAt(i);
					}
				} else {
					while (i < str.length() && (tmp != ' ' && tmp != '<')) {
						st.push(tmp);
						i++;
						if (i < str.length()) {
							tmp = str.charAt(i);
						}
					}
					while (!st.isEmpty()) {
						sb.append(st.pop());
					}
				}
			}
			System.out.println(sb);
//		}
	}
}
