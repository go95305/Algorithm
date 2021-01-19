package algorithm;

import java.util.*;
class 타일링 {

    public int solution(int n) {
        int answer = 0;
        int a=2;
        int b=1;
        for(int i=2;i<n;i++){
            int ans=(a+b)%1000000007;
            b=a;
            a=ans;
        }
        answer =a;
        return answer;
    }
}