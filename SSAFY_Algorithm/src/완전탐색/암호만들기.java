package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 암호만들기 {
    static int L, C;
    static char arr[];
    static char sel[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        st = new StringTokenizer(br.readLine()," ");
        int idx = 0;
        for (int i = 0; i < C; i ++) {
            arr[idx++] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);


        sel = new char[L];
        combination(0, 0);


    }

    private static void combination(int idx, int k) {
        if (k == sel.length) {
            int ja = 0;
            int mo = 0;
            String str = "";
            int cnt = 0;
            for (int i = 0; i < sel.length - 1; i++) {
                if (sel[i] == 'a' || sel[i] == 'e' || sel[i] == 'i' || sel[i] == 'o' || sel[i] == 'u') {
                    mo++;
                } else {
                    ja++;
                }

                if (sel[i] < sel[i + 1]) {
                    cnt++;
                    str += sel[i];
                } else
                    return;
            }
            if (sel[L - 1] == 'a' || sel[L - 1] == 'e' || sel[L - 1] == 'i' || sel[L - 1] == 'o' || sel[L - 1] == 'u') {
                mo++;
            } else
                ja++;

            if (mo == 0 || ja < 2)
                return;

            str += sel[L - 1];
            if (cnt == L - 1)
                System.out.println(str);

            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sel[k] = arr[i];
            combination(i + 1, k + 1);
        }
    }
}
