package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class B11399 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\고유창\\git\\javase\\src\\algorithm\\testcase.txt"));
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int ar[] = new int[num];//시간
		int min[] = new int[num];//누적시간
		int max = 0;//
		for (int i = 0; i < num; i++) {
			ar[i] = sc.nextInt();
		}
		Arrays.sort(ar);
		int sum = 0;
		for (int i = 0; i < ar.length; i++) {
			sum += ar[i];
			min[i] = sum;
			max += min[i];
		}
		System.out.println(max);
	}
}
