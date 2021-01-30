package algorithm;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class step{
        String nextWord;
        int cnt;
        step(String nextWord,int cnt){
            this.nextWord=nextWord;
            this.cnt=cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        int cnt=1;
        boolean isExist=false;
        boolean v[] = new boolean[words.length];
        //1. words배열에 target이 있는지부터 확인한다.
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                isExist=true;
                break;
            }
        }
        //2. 현재 단어(begin)과 한단어 차이나는 단어는 전부 큐에 넣는다 그리고 방문 체크!
        if(isExist){
            Queue<step> que = new LinkedList<>();
            que.add(new step(begin,0));
            while(!que.isEmpty()){
                step s = que.poll();
                if(s.nextWord.equals(target)){
                    answer=Math.min(answer,s.cnt);
                }
                for(int i=0;i<words.length;i++){
                    if(!v[i] && oneDiff(s.nextWord,words[i])){
                        que.add(new step(words[i],s.cnt+1));
                        v[i]=true;
                    }
                }
            }

        }else{
            answer=0;
        }

        //3. target이 나오면 cnt 최소값 갱신
        return answer;
    }
    public boolean oneDiff(String begin,String words){
        int diff=0;
        for(int i=0;i<begin.length();i++){
            char tmp1 = begin.charAt(i);
            char tmp2 = words.charAt(i);
            if(tmp1!=tmp2)
                diff++;
        }
        if(diff<=1)
            return true;
        else
            return false;
    }
}