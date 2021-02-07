package algorithm;

import java.util.Scanner;

public class B4796_캠핑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while (true) {
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();
            if (V == 0)
                break;

            int vCnt=V;
            int cnt=0;
            int lpDiff = P - L;
            while(vCnt>P){
                vCnt-=P;
                cnt+=lpDiff;
            }
            if(vCnt>=L) {
                cnt+=(vCnt-L);
            }
            int ans = V-cnt;
            System.out.println("Case " + n + ": " + ans);
            n++;
        }
    }
}
