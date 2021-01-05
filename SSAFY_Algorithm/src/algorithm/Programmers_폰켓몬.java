package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Programmers_폰켓몬 {
    static int sel[];
    static boolean v[];
    static int Ans;
    public static void main(String[] args) {
        int answer = 0;
        int[] nums={3,3,3,2,2,4};
        HashSet<Integer> hash = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hash.add(nums[i]);
        }
        if(nums.length/2<hash.size()){
            answer=nums.length/2;
        }else{
            answer=hash.size();
        }
        System.out.println(answer);
    }

}
