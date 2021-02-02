package algorithm;

import java.util.*;
class 가장먼노드 {
    static class Point{
        int to,cnt;
        Point(int to, int cnt){
            this.to=to;
            this.cnt=cnt;
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max=0;
        ArrayList<Integer> list[] = new ArrayList[n];
        for(int i=0;i<list.length;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<edge.length;i++){
            int from = edge[i][0]-1;
            int to = edge[i][1]-1;
            list[from].add(to);
            list[to].add(from);
        }

        boolean v[] = new boolean[n];
        Queue<Point> que = new LinkedList<>();
        v[0]=true;
        que.add(new Point(0,0));
        while(!que.isEmpty()){
            Point p = que.poll();
            if(p.cnt>max){
                answer=1;
                max=p.cnt;
            }
            else if(p.cnt == max){
                answer++;
            }
            int size = list[p.to].size();
            for(int j=0;j<size;j++){
                Integer next = list[p.to].get(j);
                if(!v[next]){
                    v[next]=true;
                    que.add(new Point(next,p.cnt+1));
                }
            }
        }
        return answer;
    }

}