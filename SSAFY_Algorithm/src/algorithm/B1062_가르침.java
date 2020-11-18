package algorithm;

import java.util.Scanner;

public class B1062_가르침 {
	static boolean know[];
	static int Ans;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ans = 0;
		int N, K;
		N = sc.nextInt();
		K = sc.nextInt();
		know = new boolean[26];
		String word[] = new String[K];
		String alreadyKnow = "antic";
		for (int i = 0; i < alreadyKnow.length(); i++) { // 이미 알고 있는 antic는 true로 처리
			know[alreadyKnow.charAt(i) - 'a'] = true;
		}

		for (int i = 0; i < N; i++) {
			word[i] = sc.next();
		}

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < N; j++) {
				int diff = compare(word[j], alreadyKnow);
				if (diff <= K - 5) {
					
				}
			}
		}

		System.out.println(Ans);

	}

	private static int compare(String word, String alreadyKnow) {
		int cnt = 0;
		for (int i = 0; i < word.length(); i++) {
			if (!word.contains(Character.toString(alreadyKnow.charAt(i)))) {
				cnt++;
			}
		}
		return cnt;
	}

}
