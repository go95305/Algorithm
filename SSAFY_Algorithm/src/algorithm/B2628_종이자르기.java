package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B2628_종이자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();

		int map[][] = new int[R][C];
		int tc = sc.nextInt();
		ArrayList<Integer> x = new ArrayList();
		x.add(0);
		x.add(R);
		ArrayList<Integer> y = new ArrayList();
		y.add(0);
		y.add(C);
		for (int i = 0; i < tc; i++) {
			int way = sc.nextInt();
			if (way == 0)
				x.add(sc.nextInt());
			else
				y.add(sc.nextInt());
		}
		Collections.sort(x);
		Collections.sort(y);

		int arx[] = new int[x.size()];
		int ary[] = new int[y.size()];
		for (int i = 1; i < x.size(); i++) {
			arx[i - 1] = x.get(i) - x.get(i - 1);
		}
		for (int i = 1; i < y.size(); i++) {
			ary[i - 1] = y.get(i) - y.get(i - 1);
		}
		Arrays.sort(arx);
		Arrays.sort(ary);
		
		System.out.println(arx[arx.length-1]*ary[ary.length-1]);
	}

}
