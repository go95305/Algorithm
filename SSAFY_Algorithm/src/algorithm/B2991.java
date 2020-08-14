package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B2991 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\고유창\\git\\javase\\src\\algorithm\\testcase.txt"));
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int A_rest = sc.nextInt();
		int B = sc.nextInt();
		int B_rest = sc.nextInt();
		
		int[] worker = new int[3];
		for (int i = 0; i < 3; i++) {
			int cnt=0;
			worker[i] = sc.nextInt();
			//주기문제는 나머지를 가지고 해결한다!!
			//(공격+쉬는시간)의 한주기를 이용해서 풀이
			if(worker[i]%(A+A_rest)!=0 &&worker[i]%(A+A_rest)<=A)cnt++;
			if(worker[i]%(B+B_rest)!=0 &&worker[i]%(B+B_rest)<=B)cnt++;
			System.out.println(cnt);
		}

	}
}
