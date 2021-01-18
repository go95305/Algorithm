package algorithm;

import java.util.*;
class 압축 {
    // static class Word{
    //     int num;
    //     char word;
    //     Word(int num,char word){
    //         this.num=num;
    //         this.word=word;
    //     }
    // }
    public int[] solution(String msg) {
        int[] answer = {};
        // 사전 만들기
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add(Character.toString((char)('A'+i)));
        }


        int dicIdx=27;
        //한글자, 두글자 순서대로 substring해서 사전에 존재하는 검사
        // 존재 한느데까지 진행해서 존재하는값 + 다음 값을 사전에 더한다 -> 해당 단어 msg에서 삭제
        int idx=1;
        String input="";
        String tmp="";
        while(true){
            if(idx<=msg.length()){
                tmp = msg.substring(0,idx);
            }
            if(list.contains(tmp)){
                if(idx>msg.length()){
                    ans.add(list.indexOf(input)+1);
                    break;
                }
                idx++;
                input=tmp;
            }else{
                list.add(tmp);
                ans.add(list.indexOf(input)+1);
                msg = msg.substring(idx-1,msg.length());
                idx=1;
                input="";

                // System.out.println(msg);
            }
        }
        answer = new int[ans.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }

}