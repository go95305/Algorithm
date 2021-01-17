package algorithm;

import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m=change(m);
        for(int i=0;i<musicinfos.length;i++){
            musicinfos[i]=change(musicinfos[i]);
        }
        int time=-1;
        //musicinfos만큼 for문을 실행한다(큰 묶음)
        for(int i=0;i<musicinfos.length;i++){
            String music[] = musicinfos[i].split(",");
            //1. 우선 노래 재생 시간을 구한다.
            String start[]=music[0].split(":");
            String end[]=music[1].split(":");

            int startHour = Integer.parseInt(start[0]);
            int startMin = Integer.parseInt(start[1]);
            int endHour = Integer.parseInt(end[0]);
            int endMin = Integer.parseInt(end[1]);
            int duration=0;
            duration=(endHour-startHour)*60 + (endMin-startMin);


            Queue<String> que = new LinkedList<>();
            for(int j=0;j<music[3].length();j++){
                que.add(Character.toString(music[3].charAt(j)));
            }

            System.out.println(que);
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<duration;j++){
                String tmp = que.poll();
                sb.append(tmp);
                que.add(tmp);
            }

            if(sb.toString().contains(m)){
                if(time<sb.length()){
                    answer=music[2];
                    time=sb.length();
                }
            }

        }
        return answer;
    }
    String change(String m){
        if(m.contains("C#"))
            m=m.replaceAll("C#","c");
        if(m.contains("D#"))
            m=m.replaceAll("D#","d");
        if(m.contains("F#"))
            m=m.replaceAll("F#","f");
        if(m.contains("G#"))
            m=m.replaceAll("G#","g");
        if(m.contains("A#"))
            m=m.replaceAll("A#","a");
        return m;
    }
}