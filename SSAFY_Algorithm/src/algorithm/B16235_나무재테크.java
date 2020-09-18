package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B16235_나무재테크 {
	static int dr[] = { -1, 1, 0, 0, -1, -1, 1, 1 };// 8방 탐색
	static int dc[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int map[][];
		int fertile[][];
		int N, M, K;
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		ArrayList<Integer>[][] tree = new ArrayList[N][N];
		for (int i = 0; i < tree.length; i++) {
			for (int j = 0; j < tree[i].length; j++) {
				tree[i][j] = new ArrayList<Integer>();
			}
		}
		fertile = new int[N][N];
		map = new int[N][N];// 추가되는 양분의 배열

		for (int i = 0; i < fertile.length; i++) {
			for (int j = 0; j < fertile[i].length; j++) {
				fertile[i][j] = 5;
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			tree[r][c].add(sc.nextInt());// 해당 좌표에 나무의 나이를 입력.
		}

		int year = 0;
		while (year < K) {
			/** 봄  여름*/
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Collections.sort(tree[i][j]);// 같은 칸에 나무가 여러개 존재하면 작은 나무부터 양분을 줘야하므로 정렬

					int newfertile = 0;
					ArrayList<Integer> newtree = new ArrayList<Integer>();
					for (int m = 0; m < tree[i][j].size(); m++) {
						if (fertile[i][j] >= tree[i][j].get(m)) {
							fertile[i][j] -= tree[i][j].get(m);
							newtree.add(tree[i][j].get(m) + 1);
						} else {
							// 죽은 나무의 양분을 구한다.
							newfertile = (tree[i][j].get(m) / 2);
						}
					}
					tree[i][j] = newtree;// 나무가 심어진 배열은 새로 업데이트된 나무를 가리킨다.
					fertile[i][j] += newfertile;// 양분 땅에 죽은 나무의 양분을 더해준다.
				}
			}
			/** 가을 */
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int m = 0; m < tree[i][j].size(); m++) {
						if (tree[i][j].get(m) % 5 == 0) {// 5의 배수이면
							newtree(tree, i, j, N);// 새로운 나무 추가
						}
					}
				}
			}

			/** 겨울 */
			for (int i = 0; i < fertile.length; i++) {
				for (int j = 0; j < fertile[i].length; j++) {
					fertile[i][j] += map[i][j]; // 양분을 추가되는 양분에 더해준다.
				}
			}
			year++;
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt += tree[i][j].size();
			}
		}
		System.out.println(cnt);

	}

	private static void newtree(ArrayList<Integer>[][] tree, int r, int c, int size) {
		for (int k = 0; k < 8; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nr < size && nc >= 0 && nc < size) {
				tree[nr][nc].add(1);
			}
		}

	}
}
