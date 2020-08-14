package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class B3985 {
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("C:\\Users\\multicampus\\git\\javase\\src\\algorithm\\testcase.txt"));
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] rollcake = new int[num];
		int people = sc.nextInt();
		int[] max_people = new int[people];
		boolean[] chk = new boolean[num];
		int expted_max = 0;
		int num_max=0;
		int max=0;
		int ans=0;
		for (int i = 0; i < people; i++) {
			int st = sc.nextInt();
			int end = sc.nextInt();
			st -= 1;
			end -= 1;
			if ((end - st) > num_max) {
				num_max=(end-st);
				expted_max = i+1;
			}
			for (int k = st; k <= end; k++) {
				if (chk[k] == false) {
					chk[k] = true;
					rollcake[k] = i + 1;
					max_people[i]++;
				}
			}
		}
		for(int i=0;i<max_people.length;i++) {
			if(max_people[i]>max) {
				max=max_people[i];
				ans=i+1;
			}
		}
		System.out.println(expted_max);
		System.out.println(ans);
	}
}
