package algorithm;

import java.util.Scanner;

public class B20055_컨베이어벨트위의로봇 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int belt[] = new int[2 * N];
		boolean robot[] = new boolean[2 * N];

		for (int i = 0; i < 2 * N; i++) {
			belt[i] = sc.nextInt();
		}
		int turn = 1;
		while (true) {
			moveBelt(belt, robot, N);
			moveRobot(belt, robot, N);
			addRobot(belt, robot, N);
			if (chkLife(belt, K))
				break;
			turn++;
		}
		System.out.println(turn);

	}

	private static boolean chkLife(int[] belt, int k) {
		int tmp = 0;
		for (int i = 0; i < belt.length; i++) {
			if (belt[i] == 0)
				tmp++;
		}
		if (tmp >= k)
			return true;
		else
			return false;
	}

	private static void addRobot(int[] belt, boolean[] robot, int n) {
		if (belt[0] > 0 && !robot[0]) {
			robot[0] = true;
			belt[0]--;
		}
	}

	private static void moveRobot(int[] belt, boolean[] robot, int n) {
		for (int i = n - 2; i >= 0; i--) {
			if (belt[i + 1] > 0 && !robot[i + 1] && robot[i]) {
				belt[i + 1]--;
				robot[i + 1] = true;
				robot[i] = false;
			}
		}
		robot[n - 1] = false;
	}

	private static void moveBelt(int[] belt, boolean[] robot, int n) {
		// 로봇이동
		for (int i = n - 2; i >= 0; i--) {
			if (robot[i]) {
				robot[i + 1] = true;
				robot[i] = false;
			}
		}
		robot[n-1]=false;
		// 벨트 이동
		int beltTmp = belt[2 * n - 1]; // 벨트 마지막 값을 저장
		for (int i = 2 * n - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = beltTmp;

	}
}

