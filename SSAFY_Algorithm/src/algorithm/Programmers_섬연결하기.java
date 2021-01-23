package algorithm;

import java.util.*;
//크루스칼
class 섬연결하기 {
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
        Edge(int from,int to,int weight){
            this.from=from;
            this.to=to;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }
    }

    static Edge[] edgeList;
    static int[] parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        int e = costs.length;
        edgeList = new Edge[e];
        for(int i=0;i<costs.length;i++){
            int from=costs[i][0];
            int to = costs[i][1];
            int weight = costs[i][2];
            edgeList[i] = new Edge(from,to,weight);
        }

        //정렬한다.
        Arrays.sort(edgeList);
        //각 정점은 자기를 부모로 가지게 초기화한다.
        make(n);
        int cnt=0;
        for(Edge edge : edgeList){
            if(union(edge.from,edge.to)){
                cnt++;
                answer+=edge.weight;
                if(cnt==n-1){
                    break;
                }
            }
        }

        return answer;
    }
    void make(int Edge){
        for(int i=0;i<Edge;i++){
            parents[i]=i;
        }
    }
    boolean union(int x,int y){
        int xRoot = find(x);
        int yRoot=find(y);
        if(xRoot==yRoot){
            return false;
        }
        parents[yRoot]=xRoot;
        return true;
    }
    int find(int a){
        if(a==parents[a])
            return a;
        else{
            return parents[a]=find(parents[a]);
        }
    }

}