package algorithm;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
public class Programmers_기능개발 {
    static class Point{
        int progress,speed,day;
        Point(int progress,int speed,int day){
            this.progress=progress;
            this.speed=speed;
            this.day=day;
        }
    }
    public static void main(String[] args) {
        int[] progresses={93,30,55};
        int[] speeds={1,30,5};
        int[] answer = {};
        int [] spend= new int[100];
        Queue<Point> que = new LinkedList<>();
        Queue<Integer> days = new LinkedList<>();
        //que에 넣기
        for(int i=0;i<progresses.length;i++){
            que.add(new Point(progresses[i],speeds[i],0));
        }

        //day, span 변수 초기화
        int span=0;

        //que가 empty될때까지 무한 반복
        while(!que.isEmpty()){
            Point p = que.poll();
            //span이 0일때만 꺼낸다.
            if(span==0){
                if(p.progress>=100){//100보다 크면 완성된거니깐 걸린 날수를 days 큐에 넣는다.
                    spend[p.day]++;
                }else{//아직 100이 아니면 다시 que에 넣는다.
                    que.add(new Point(p.progress+p.speed,p.speed,p.day+1));
                    span++;
                }
            }else{
                que.add(new Point(p.progress+p.speed,p.speed,p.day+1));
                span++;
            }
            if(span==que.size()){
                span=0;
            }
        }
        for(int i=0;i<spend.length;i++){
            if(spend[i]>0)
                days.add(spend[i]);
        }
        int idx=0;
        answer = new int[days.size()];
        while(!days.isEmpty()){
            answer[idx]=days.poll();
            idx++;
        }
        System.out.println(Arrays.toString(answer));
    }
}
