package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B16235_나무재테크 {
	static int N, M, K;
	static int map[][];//
	static int fertilizer[][];
	static int dr[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dc[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int age;

		Point(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.age, o.age);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		fertilizer = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();// 겨울에 추가되는 각 땅의 양분의 양을 저장
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				fertilizer[i][j] = 5;
			}
		}
		ArrayList<Point> tree = new ArrayList<Point>();
		for (int i = 0; i < M; i++) {
			tree.add(new Point(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));// 나무를 리스트에 등록
		}
		int year = 0;
		while (year < K) {
			// 봄
			Collections.sort(tree);
			ArrayList<Point> newTree = new ArrayList<Point>();
			ArrayList<Point> addFer = new ArrayList<Point>();
			for (int i = 0; i < tree.size(); i++) {
				Point p = tree.get(i);
				if (fertilizer[p.r][p.c] >= p.age) {
					fertilizer[p.r][p.c] = fertilizer[p.r][p.c] - p.age;
					newTree.add(new Point(p.r, p.c, p.age + 1));
				} else {
					addFer.add(new Point(p.r, p.c, p.age / 2));// addFer에 죽은 나무의 양분을 저장
				}
			}
			tree = newTree;
			// 여름
			newFer(addFer);

			// 가을
			for (int i = 0; i < tree.size(); i++) {
				if (tree.get(i).age % 5 == 0 && tree.get(i).age > 0) {
					addTree(tree.get(i).r, tree.get(i).c, tree);
				}
			}

			// 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					fertilizer[i][j] += map[i][j];
				}
			}
			year++;
		}
		System.out.println(tree.size());// 살아있는 나무개수 출력

	}

	private static void newFer(ArrayList<Point> addFer) {
		for (int i = 0; i < addFer.size(); i++) {
			Point p = addFer.get(i);
			fertilizer[p.r][p.c] += p.age;
		}
	}

	private static void addTree(int r, int c, ArrayList<Point> tree) {
		for (int k = 0; k < 8; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N)
				tree.add(new Point(nr, nc, 1));
		}
	}

}
