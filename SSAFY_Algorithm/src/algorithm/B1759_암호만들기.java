package algorithm;

import java.io.*;
import java.util.*;

public class B1759_암호만들기 {
    static char num[];
    static char sel[];
    static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        num = new char[C];
        sel = new char[L];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            num[i] = st.nextToken().charAt(0);
        }
        //나중에 사전식으로 정렬 필요없이 여기서 sort하면 결과는 사전식으로 나온다.
        Arrays.sort(num);
        combi(0, 0);
    }

    private static void combi(int idx, int k) {
        if (k == sel.length) {
            String str = "";
            int cnt = 0;
            int moum = 0;
            int jaum = 0;
            //for문을 통해 순서대로 알파벳의 사전식을 확인
            for (int j = 0; j < sel.length - 1; j++) {
                if (sel[j] == 'a' || sel[j] == 'e' || sel[j] == 'i' || sel[j] == 'o' || sel[j] == 'u')
                    moum++;
                else
                    jaum++;
                if (sel[j] < sel[j + 1]) {
                    cnt++;
                    str += sel[j];
                } else
                    return;
            }
            //마지막 문자 하나는 확인 못했으므로 확인
            if (sel[L - 1] == 'a' || sel[L - 1] == 'e' || sel[L - 1] == 'i' || sel[L - 1] == 'o' || sel[L - 1] == 'u')
                moum++;
            else
                jaum++;
            //모음이 최소 1개 자음이 최소 2개인지 확인
            if (moum == 0 || jaum < 2)
                return;
            str += sel[L - 1];
            if (cnt == L - 1) {
                System.out.println(str);
            }
            //확인됬으면 그대로 출력력
            return;
        }

        for (int i = idx; i < num.length; i++) {
            sel[k] = num[i];
            combi(i + 1, k + 1);
        }
    }

}
