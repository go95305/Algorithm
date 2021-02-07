package algorithm;

import java.util.*;
class 단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int []o2){
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                else
                    return o1[0]-o2[0];
            }
        });


        int answer = 1;
        int left = -30000;
        int right=30000;
        for(int i=0;i<routes.length;i++){
            int curLeft = routes[i][0];
            int curRight = routes[i][1];
            if(right>=curRight && left<=curLeft){
                left=curLeft;
                right=curRight;
            }else{
                if(curLeft>right){
                    answer++;
                    left=curLeft;
                    right=curRight;
                }

            }
        }
        return answer;
    }
}