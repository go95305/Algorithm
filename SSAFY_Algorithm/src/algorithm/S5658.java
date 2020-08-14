package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S5658 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			Queue<Character> que = new LinkedList<Character>();
			int N = sc.nextInt();
			int K = sc.nextInt();
			String str = sc.next();
			for (int i = 0; i < str.length(); i++) {
				que.offer(str.charAt(i));
			}
			String st = "";
			HashSet<Integer> hs = new HashSet<Integer>();
			for (int j = 0; j < N / 4; j++) {
				for (int i = 1; i <= que.size(); i++) {
					char tmp = que.poll();
					st += tmp;
					if (i % (N / 4) == 0) {
						hs.add(Integer.parseInt(st, 16));
						st = "";
					}
					que.add(tmp);
				}
				char tmp = que.poll();
				que.add(tmp);
			}
			ArrayList<Integer> list = new ArrayList(hs);
			Collections.sort(list, Collections.reverseOrder());
			System.out.printf("#%d %d\n", test_case, list.get(K-1));

		}
	}
}
