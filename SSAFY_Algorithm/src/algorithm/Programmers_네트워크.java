package algorithm;

import java.util.*;
class 네트워크 {
    static boolean v[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        ArrayList<Integer> list[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(computers[i][j]==1){
                    list[i].add(j);
                    list[j].add(i);
                }

            }
        }

        int network=0;
        v = new boolean[n];
        for(int i=0;i<n;i++){
            if(!v[i]){
                bfs(i,list);
                network++;
            }
        }



        answer =network;
        return answer;
    }
    void bfs(int idx,ArrayList<Integer> list[]){
        Queue<Integer> que = new LinkedList<>();
        que.add(idx);
        v[idx]=true;
        while(!que.isEmpty()){
            Integer n = que.poll();
            int size = list[n].size();
            for(int i=0;i<size;i++){
                int num = list[n].get(i);
                if(!v[num]){
                    v[num]=true;
                    que.add(num);
                }
            }
        }
    }

}