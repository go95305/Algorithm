package algorithm;

import java.lang.reflect.Array;
import java.util.*;

public class B2644_촌수계산 {
    static int N, M;
    static ArrayList<Point>[] list;
    static boolean v[];
    static int Ans;

    static class Point {
        int to, weight;

        Point(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "to=" + to +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList[N + 1];

        //각 사람마다 여러명이 연결 될 수 있으므로 ArrayList 배열을 사용.
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        Ans = -1;
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            list[from].add(new Point(to, 0));
            list[to].add(new Point(from, 0));//부모로 갔다가 다시 자식쪽으로 내려오고 다시 올라오고 내려오고를 할수 있어야 하므로 양방향으로 연결한다.
        }
        v = new boolean[N + 1];//해당 사람을 방문했으면 다시는 안가게 하기위해 , 아니면 무한 루프.


        Queue<Point> que = new LinkedList<>();
        que.add(new Point(start, 0));//첫 번째 당사자 입장에서는 0촌이다.
        //7번이랑 3번이 몇 촌인지구하는것이므로 7번 부터 시작!, 3번으로 해도 될라나?
        v[start] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();//해당 사람정보
            if (p.to == end) {//방문한 사람이 목적지 사람이랑 같으면 종료
                Ans = p.weight;
            }
            for (int i = 0; i < list[p.to].size(); i++) {//해당 사람이랑 연결된 모든 사람수만큼 돌린다.
                Integer n = list[p.to].get(i).to;
                if (!v[n]) {//만약 이미 방문한 사람이면 다시 가지않고 방문하지 않았으면 그 사람한테 접근.
                    v[n] = true;
                    que.add(new Point(n, p.weight + 1));//p.weight+1을 해주는 이유는 다른 사람한테 갈때마다 1촌씩 증가하기 때문에!.왔던 길을 다시 오는 경우는없으므로 -1을 하는 경우는 없다.
                }

            }
        }
        System.out.println(Ans);
    }
}
