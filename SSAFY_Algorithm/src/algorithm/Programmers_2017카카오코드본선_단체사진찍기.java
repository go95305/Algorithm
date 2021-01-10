package algorithm;

import java.util.Arrays;

public class Programmers_2017카카오코드본선_단체사진찍기 {
    static char sel[];
    static boolean v[];
    static char friends[];
    static char conditions[][];
    static int Ans;
    static int dist[];

    public static void main(String[] args) {
        int answer = 0;
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        conditions = new char[data.length][4]; // 나중에 비교할 조건들 저장할 배열
        dist = new int[data.length];
        //조건들을 배열에 저장
        for (int i = 0; i < data.length; i++) {
            char tmp[] = data[i].toCharArray();
            conditions[i][0] = tmp[0];
            conditions[i][1] = tmp[2];
            conditions[i][2] = tmp[3];
            int distTmp = tmp[4];
            switch (distTmp) {
                case '0':
                    dist[i] = 0;
                    break;
                case '1':
                    dist[i] = 1;
                    break;
                case '2':
                    dist[i] = 2;
                    break;
                case '3':
                    dist[i] = 3;
                    break;
                case '4':
                    dist[i] = 4;
                    break;
                case '5':
                    dist[i] = 5;
                    break;
                case '6':
                    dist[i] = 6;
                    break;
            }
        }
        sel = new char[8];
        Ans = 0;
        friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        v = new boolean[8];
        combination(0, 0);

        answer = Ans;
        System.out.println(answer);

    }

    private static void combination(int idx, int k) {
        if (sel.length == k) {
            boolean flag = conChk(sel);
            if (flag) {
                Ans++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!v[i]) {
                v[i] = true;
                sel[k] = friends[i];
                combination(idx + 1, k + 1);
                v[i] = false;
            }
        }
    }

    private static boolean conChk(char[] sel) {
        boolean flag = true;
        for (int i = 0; i < conditions.length; i++) {
            if (!flag) {
                return false;
            }
            char n1 = conditions[i][0];
            char n2 = conditions[i][1];
            char n3 = conditions[i][2];
            int n1Idx = 0;
            int n2Idx = 0;
            for (int j = 0; j < sel.length; j++) {
                if (sel[j] == n1)
                    n1Idx = j;
                if (sel[j] == n2)
                    n2Idx = j;
            }

            switch (n3) {
                case '=':
                    if (dist[i] + 1 == Math.abs(n1Idx - n2Idx)) {
                        flag = true;
//                        System.out.println(dist[i] + 1 + " : " + Math.abs(n1Idx - n2Idx));
                    } else
                        flag = false;
                    break;
                case '>':
                    if (dist[i] + 1 < Math.abs(n1Idx - n2Idx)) {
                        flag = true;
                    } else
                        flag = false;
                    break;
                case '<':
                    if (dist[i] + 1 > Math.abs(n1Idx - n2Idx)) {
                        flag = true;
                    } else
                        flag = false;
                    break;
            }
        }
        return flag;
    }
}
