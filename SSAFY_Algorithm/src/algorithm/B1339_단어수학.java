package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1339_단어수학 {
	static int N;// 총 문자열 개수
	static int ar[];// 초기 순열 값(순열을 돌리기 전에) ex(9,8,7,6,...)
	static boolean v[]; // 방문 배열
	static int sel[];// 순열 배열
	static String tmp[];// 문자열 입력받는 배열
	static int max;// 최대값
	static int[] arr;// 문자에 대한 인덱스를 지정한 배열
	static int p;// 인덱스

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		tmp = new String[N];
		arr = new int[26];// 알파벳 숫자만큼 크기 생성

		p = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			tmp[i] = st.nextToken();
			for (int j = 0; j < tmp[i].length(); j++) {
				if (arr[tmp[i].charAt(j) - 'A'] == 0) {// 이미 똑같은 알파벳이 이전에 들어왔으면 넘기고 아니면 인덱스를 넣어준다.
					arr[tmp[i].charAt(j) - 'A'] = p;
					p++;// 다음은덱스는 이전보다 +1이어야한다.
				}
			}
		}
		p--;// 위의 for문 끝나면 인덱스가 알파벳숫자보다 하나 더 많으므로 -1 해준다.
		ar = new int[p];// 초기 순열 배열의 크기는 P만큼
		v = new boolean[p];
		sel = new int[p];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = 9 - i;// 크기만큼 9 8 7 ...대로 입력
		}

		max = 0;
		permutation(0);// 순열
		System.out.println(max);

	}

	private static void permutation(int k) {
		if (k == sel.length) {

			int ans = 0;
			for (int i = 0; i < tmp.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < tmp[i].length(); j++) {
					sb.append(sel[arr[tmp[i].charAt(j) - 'A'] - 1]);// arr에 저장된 문자의 위치 인덱스를 가져와서 순열 배열에 넣어줘서 값을 구한다. -1을
																	// 하는 이유는 sel의 인덱스가 0 부터 인데 1부터 시작되므로.
				}
				ans += Integer.parseInt(sb.toString());

			}
			if (max < ans) {
				max = ans;
			}
			return;
		}
		for (int i = 0; i < ar.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = ar[i];
				permutation(k + 1);
				v[i] = false;
			}
		}
	}

}
