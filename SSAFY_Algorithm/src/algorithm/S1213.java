package algorithm;

import java.util.Scanner;

public class S1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int num = sc.nextInt();
			String str = sc.next();
			String str2 = sc.next();
			if (str2.contains(str)) {
				str2 = str2.replaceAll(str, "*");
			}
			int cnt=0;
			for(int i=0;i<str2.length();i++) {
				if(str2.charAt(i)=='*') {
					cnt++;
				}
			}
			System.out.printf("#%d %d\n",num,cnt);
		}
	}
}
