package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B2941 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\multicampus\\git\\algorithm\\Algorithm\\src\\testcase2.txt"));
		Scanner sc = new Scanner(System.in);

		String num = sc.nextLine();
		int cnt = 0;
		int numlen = num.length();
		String[] cro = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		for (int i = 0; i < cro.length; i++) {
			if (num.contains(cro[i])) {
				cnt++;
				num = num.replace(cro[i], "*");
			}
		}
		System.out.println(num.length());
	}
}
