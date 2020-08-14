package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S7272 {
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("C:\\Users\\고유창\\git\\javase\\src\\algorithm\\testcase.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String answer = "SAME";
			int a = 0;
			int b = 0;
			String first = sc.next();
			String[] x = first.split("");
			String second = sc.next();
			String[] y = second.split("");

			for (int i = 0; i < first.length(); i++) {
				if (first.length() != second.length()) {
					answer = "DIFF";
					break;
				}
				if (x[i].equals("A") || x[i].equals("D") || x[i].equals("O") || x[i].equals("P") || x[i].equals("Q")
						|| x[i].equals("R")) {
					a = 1;
				} else if (x[i].equals("B")) {
					a = 2;
				} else {
					a = 0;
				}

				if (y[i].equals("A") || y[i].equals("D") || y[i].equals("O") || y[i].equals("P") || y[i].equals("Q")
						|| y[i].equals("R")) {
					b = 1;
				} else if (y[i].equals("B")) {
					b = 2;
				} else {
					b = 0;
				}
				if (a != b) {
					answer = "DIFF";
					break;
				}
			}
			System.out.printf("#%d %s\n", test_case, answer);
		}
	}
}
