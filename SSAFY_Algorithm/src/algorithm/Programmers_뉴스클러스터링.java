package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Programmers_뉴스클러스터링 {
    public static void main(String[] args) {
        int answer = 0;
        String str1 = "a_";
        String str2 = "a_";
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();


        // 두글자씩 잘라서 Queue에 넣기
        Queue<String> q1 = new LinkedList();
        Queue<String> q2 = new LinkedList();
        int cut = 0;
        String tmp = "";
        for (int i = 0; i < str1.length(); i++) {
            if (cut == 2) {
                cut = 0;
                q1.add(tmp);
                tmp = "";
                i -= 1;
            }
            if ('a' <= str1.charAt(i) && 'z' >= str1.charAt(i)) {
                tmp += Character.toString(str1.charAt(i));
            } else {
                tmp = "";
                cut = 0;
                continue;
            }
            cut++;
        }
        if (tmp.length() == 2)
            q1.add(tmp);
        tmp = "";
        cut = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (cut == 2) {
                cut = 0;
                q2.add(tmp);
                tmp = "";
                i -= 1;
            }
            if ('a' <= str2.charAt(i) && 'z' >= str2.charAt(i)) {
                tmp += Character.toString(str2.charAt(i));
            } else {
                tmp = "";
                cut = 0;
                continue;
            }
            cut++;
        }
        if (tmp.length() == 2)
            q2.add(tmp);


        //교집합 구하기
        int same = 0;
        int sum = 0;
        while (!q1.isEmpty()) {
            String word=q1.poll();
            if(q2.remove(word)){
                same++;
            }
            sum++;
        }
        sum+=q2.size();
        double subAns = 0;
        if (sum==0)
            subAns = 1;
        else
            subAns = (double) same / (double) sum;

        answer = (int) (subAns * 65536);
        System.out.println(answer);

    }
}
