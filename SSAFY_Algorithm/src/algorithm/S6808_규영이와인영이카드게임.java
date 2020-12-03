package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class S6808_규영이와인영이카드게임 {
    static int gMap[],iMap[];
    static int sel[];
    static boolean v[];
    static int cnt;
    static int gWin, iWin;
    static int finalWin, finalLose;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            gMap = new int[9];
            iMap = new int[9];
            sel = new int[9];
            v = new boolean[9];
            boolean vNum[] = new boolean[19];
            for (int i = 0; i < 9; i++) {
                gMap[i] = sc.nextInt();
            }
            int index = 0;
            iMap = new int[9];
            for (int i = 0; i < gMap.length; i++) {
                vNum[gMap[i]]=true;
            }

            for (int i = 1; i < vNum.length; i++) {
                if(!vNum[i]) {
                    iMap[index] = i;
                    index++;
                }
            }

//            cnt = 0;

            finalWin = 0;
            finalLose = 0;
            permutation(0, 0);
            System.out.println("#" + tc + " " + finalWin + " " + finalLose);
        }
    }

    private static void permutation(int idx, int k) {
        if (k == sel.length) {
            gWin = 0;
            iWin = 0;
            whoWin(sel);
            return;
        }

        for (int i = 0; i < iMap.length; i++) {
            if (!v[i]) {
                v[i] = true;
                sel[k] = iMap[i];
                permutation(idx + 1, k + 1);
                v[i] = false;
            }
        }
    }

    private static void whoWin(int[] sel) {
        for (int i = 0; i < sel.length; i++) {
            if (gMap[i] > sel[i])//해당 카드가 규영이가 더 큰경우
                gWin += gMap[i] + sel[i];
            else if (gMap[i] < sel[i])// 해당 카드가 규영이가 더 작은 경우
                iWin += gMap[i] + sel[i];
        }

        if (gWin > iWin) {
            finalWin++;
        } else if (gWin < iWin) {
            finalLose++;
        }
    }
}
