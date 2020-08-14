package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S4615 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\고유창\\git\\javase\\src\\algorithm\\testcase.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };// 상,하,좌,우,왼쪽위대각,오른쪽위대각,왼쪽아래대각,왼쪽위대각
		int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

		for (int test_case = 1; test_case <= T; test_case++) {
			int blackCnt = 0;
			int whiteCnt = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] ar = new char[N][N];

			int st = (N / 2) - 1;
			ar[st][st] = 'W';
			ar[st][st + 1] = 'B';
			ar[st + 1][st] = 'B';
			ar[st + 1][st + 1] = 'W';

			for (int i = 0; i < M; i++) {// 0 1 2
				int x = sc.nextInt();
				int y = sc.nextInt();
				int turn = sc.nextInt();
				if (turn == 1) {
					ar[x - 1][y - 1] = 'B';
				} else {
					ar[x - 1][y - 1] = 'W';
				}

				for (int k = 0; k < 8; k++) {
					int nr = (x - 1) + dr[k];
					int nc = (y - 1) + dc[k];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						int cnt;
						int tmpr;
						int tmpc;
						char dol;
						switch (k) {
						case 0:// 위로 검색
							if (turn == 1) {
								dol = 'W';
							} else {
								dol = 'B';
							}
							cnt = 1;
							tmpr = nr;
							tmpc = nc;
							if (ar[tmpr][tmpc] == dol) {// 인접한 돌이 상대돌이면
								while (tmpr >= 0 && ar[tmpr][tmpc] == dol) {
									cnt++;
									tmpr -= 1;
								}
							}
							if (dol == 'W') {
								dol = 'B';
								if (tmpr >= 0 && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr - j][nc] = dol;
									}
								}
							} else if (dol == 'B') {
								dol = 'W';
								if (tmpr >= 0 && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr - j][nc] = dol;
									}
								}
							}
							break;
						case 1:// 아래로 검색
							if (turn == 1) {
								dol = 'W';// 내가 흑돌이면 백돌을 선택
							} else {
								dol = 'B';// 내가 백돌이면 흑돌을 선택
							}
							cnt = 0;
							tmpr = nr;
							tmpc = nc;
							if (ar[tmpr][tmpc] == dol) {// 인접한 돌이 상대돌이면
								while (tmpr < N && ar[tmpr][tmpc] == dol) {
									cnt++;
									tmpr += 1;
								}
							}
							if (dol == 'W') {
								dol = 'B';
								if (tmpr < N && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr + j][nc] = dol;
									}
								}
							} else if (dol == 'B') {
								dol = 'W';
								if (tmpr < N && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr + j][nc] = dol;
									}
								}
							}
							break;
						case 2:// 좌
							if (turn == 1) {
								dol = 'W';
							} else {
								dol = 'B';
							}
							cnt = 0;
							tmpr = nr;
							tmpc = nc;
							if (ar[tmpr][tmpc] == dol) {// 인접한 돌이 상대돌이면
								while (tmpc >= 0 && ar[tmpr][tmpc] == dol) {
									cnt++;
									tmpc -= 1;
								}
							}
							if (dol == 'W') {
								dol = 'B';
								if (tmpc >= 0 && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr][nc - j] = dol;
									}
								}
							} else if (dol == 'B') {
								dol = 'W';
								if (tmpc >= 0 && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr][nc - j] = dol;
									}
								}
							}
							break;
						case 3:// 우
							if (turn == 1) {
								dol = 'W';
							} else {
								dol = 'B';
							}
							cnt = 0;
							tmpr = nr;
							tmpc = nc;
							if (ar[tmpr][tmpc] == dol) {// 인접한 돌이 상대돌이면
								while (tmpc < N && ar[tmpr][tmpc] == dol) {
									cnt++;
									tmpc += 1;
								}
							}
							if (dol == 'W') {
								dol = 'B';
								if (tmpc < N && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr][nc + j] = dol;
									}
								}
							} else if (dol == 'B') {
								dol = 'W';
								if (tmpc < N && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr][nc + j] = dol;
									}
								}
							}

							break;
						case 4:// 왼쪽위 대각선
							if (turn == 1) {
								dol = 'W';
							} else {
								dol = 'B';
							}
							cnt = 0;
							tmpr = nr;
							tmpc = nc;
							if (ar[tmpr][tmpc] == dol) {// 인접한 돌이 상대돌이면
								while (tmpr >= 0 && tmpc >= 0 && ar[tmpr][tmpc] == dol) {
									cnt++;
									tmpc -= 1;
									tmpr -= 1;
								}
							}
							if (dol == 'W') {
								dol = 'B';
								if (tmpr >= 0 && tmpc >= 0 && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr - j][nc - j] = dol;
									}
								}
							} else if (dol == 'B') {
								dol = 'W';
								if (tmpr >= 0 && tmpc >= 0 && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr - j][nc - j] = dol;
									}
								}
							}
							break;
						case 5:// 오른쪽 대각선 위
							if (turn == 1) {
								dol = 'W';
							} else {
								dol = 'B';
							}
							cnt = 0;
							tmpr = nr;
							tmpc = nc;
							if (ar[tmpr][tmpc] == dol) {// 인접한 돌이 상대돌이면
								while (tmpr >= 0 && tmpc < N && ar[tmpr][tmpc] == dol) {
									cnt++;
									tmpc += 1;
									tmpr -= 1;
								}
							}
							if (dol == 'W') {
								dol = 'B';
								if (tmpr >= 0 && tmpc < N && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr - j][nc + j] = dol;
									}
								}
							} else if (dol == 'B') {
								dol = 'W';
								if (tmpr >= 0 && tmpc < N && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr - j][nc + j] = dol;
									}
								}
							}
							break;
						case 6:// 왼쪽 대각선 아래
							if (turn == 1) {
								dol = 'W';
							} else {
								dol = 'B';
							}
							cnt = 0;
							tmpr = nr;
							tmpc = nc;
							if (ar[tmpr][tmpc] == dol) {// 인접한 돌이 상대돌이면
								while (tmpr < N && tmpc >= 0 && ar[tmpr][tmpc] == dol) {
									cnt++;
									tmpc -= 1;
									tmpr += 1;
								}
							}
							if (dol == 'W') {
								dol = 'B';
								if (tmpr < N && tmpc >= 0 && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr + j][nc - j] = dol;
									}
								}
							} else if (dol == 'B') {
								dol = 'W';
								if (tmpr < N && tmpc >= 0 && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr + j][nc - j] = dol;
									}
								}
							}
							break;
						case 7:// 오른쪽 대각선 아래
							if (turn == 1) {
								dol = 'W';
							} else {
								dol = 'B';
							}
							cnt = 0;
							tmpr = nr;
							tmpc = nc;
							if (ar[tmpr][tmpc] == dol) {// 인접한 돌이 상대돌이면
								while (tmpr < N && tmpc < N && ar[tmpr][tmpc] == dol) {
									cnt++;
									tmpc += 1;
									tmpr += 1;
								}
							}
							if (dol == 'W') {
								dol = 'B';
								if (tmpr < N && tmpc < N && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr + j][nc + j] = dol;
									}
								}
							} else if (dol == 'B') {
								dol = 'W';
								if (tmpr < N && tmpc < N && ar[tmpr][tmpc] == dol) {
									for (int j = 0; j < cnt; j++) {
										ar[nr + j][nc + j] = dol;
									}
								}
							}
							break;
						}

					}
				}

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (ar[i][j] == 'B')
						blackCnt++;
					else if (ar[i][j] == 'W') {
						whiteCnt++;
					}
				}
			}

			System.out.printf("#%d %d %d\n", test_case, blackCnt, whiteCnt);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(ar[i][j] + " ");
				}
				System.out.println();
			}

		}
	}
}
