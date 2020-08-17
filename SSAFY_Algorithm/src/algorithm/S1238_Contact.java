package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1238_Contact {
	static ArrayList<Integer>[] adj;//초기 값들을 입력하기 위한 인접리스트
	static ArrayList<Point> Ans;// bfs를 통해 마지막 레벨(깊이)에서 결과값을 찾기위한 인접행렬
	static boolean v[];// bfs 알고리즘을 사용하면서 한 번 방문한 곳은 다시는 방문하지 않기 위한 boolean형 배열
	static int lev;
	static ArrayList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();//인접행렬의 크기
			adj = new ArrayList[N];
			Ans = new ArrayList<Point>();//Point클래스를 만들어서 각각 노드의 값과 깊이를 저장한다.
			lev = 0;
			int start = sc.nextInt();
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<Integer>();//인접리스트 객체 생성
			}
			v = new boolean[N];
			for (int i = 0; i < N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adj[from].add(to);//각각 값들을 인접리스트에 입력
			}
			bfs(start, 0);//bfs를 주어진 시작값 위치부터 깊이0으로 시작.
			list = new ArrayList<Integer>();
			for (int i = 0; i < Ans.size(); i++) {
				if (Ans.get(i).level == lev) {//최대 깊이의 노드 값들만 따로 리스트에 저장
					list.add(Ans.get(i).p);
				}
			}
			Collections.sort(list, Collections.reverseOrder());//역순으로 정렬한다.
			System.out.printf("#%d %d\n",test_case,list.get(0));//출력
		}
	}

	private static void bfs(int start, int level) {
		Queue<Point> que = new LinkedList();
		v[start] = true;
		que.add(new Point(start, level));
		while (!que.isEmpty()) {//Queue가 비어있지않으면 계속 실행
			Point p = que.poll();
			Ans.add(new Point(p.p, p.level));//하나씩 모든 값들을 레벨과 인접리스트에 저장
			lev = p.level;//bfs가 끝나고나서 마지막 깊이가 어딘지 파악하기 위해 사용.
			int size = adj[p.p].size();
			for (int i = 0; i < size; i++) {
				Integer n = adj[p.p].get(i);
				if (!v[n]) {
					v[n] = true;
					que.add(new Point(n, p.level + 1));
				}
			}
		}

	}

	static class Point {
		int p;
		int level;

		Point(int p, int level) {
			this.p = p;
			this.level = level;
		}

	}

}
