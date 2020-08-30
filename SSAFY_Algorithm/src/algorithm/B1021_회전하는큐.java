package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class B1021_회전하는큐 {
	static int N, M, cnt;
	static Stack<Integer> que = new Stack<Integer>();
	static Queue<Integer> sel = new LinkedList<Integer>();
	static int place;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		cnt = 0;
		for (int i = 1; i <= N; i++) {
			que.add(i);// N크기 만큼 1~순차적으로 값을 스택에 저장
		}
		for (int i = 1; i <= M; i++) {
			sel.add(sc.nextInt());// 뽑을 숫자들을 que에 넣는다.
		}

		while (!sel.isEmpty()) {//더 이상 뽑을 게 없을 때까지 진행
			place = 1;
			if (sel.peek() == que.get(0)) {//각각 스택과 큐의 맨 앞 숫자가 같으면 뽑아낸다.
				que.remove(0);
				sel.poll();
			} else {
				if (que.indexOf(sel.peek()) + 1 <= que.size() / 2 + 1) {//다음으로 뽑아낼 숫자의 위치가 큐의 중앙보다 왼쪽에 있으면
					while (sel.peek() != que.get(0)) {//해당 숫자를 맨앞으로 보낸다.(왼쪽으로 이동)
						int tmp = que.get(0);
						que.remove(0);
						que.push(tmp);
						cnt++;
					}
				} else {
					while (sel.peek() != que.get(0)) {//해당 숫자를 맨앞으로 보낸다.(오른쪽으로 이동)
						int tmp = que.pop();
						que.add(0, tmp);
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);

	}
}
