package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B1449_수리공항승 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer =0;
        int N = sc.nextInt();
        int L = sc.nextInt();
        int map[] = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextInt() - 1;
        }

        boolean v[] = new boolean[1001];
        Arrays.sort(map);
        for (int i = 0; i < map.length; i++) {
            int water = map[i];
            //해당 좌표 +0.5가 chk인지 확인
            if (v[water]) {
                if (v[water + 1])
                    continue;
                taping(v, water + 1, L);
                answer++;
            } else {
                taping(v, water, L);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void taping(boolean[] v, int water, int len) {
        for (int i = water; i <= water + len; i++) {
            v[i] = true;
        }
    }


}
//우선 해당 좌표가 chk인지 확인
//  1. Yes ->   +1이 chk인지 확인
//              1-1 yes ->  continue
//              1-2 no  ->  +1부터 l만큼 테이핑 (ans+1)
//  2. no  -> 현재좌표부터 +L만큼 테이핑(ans+1)
