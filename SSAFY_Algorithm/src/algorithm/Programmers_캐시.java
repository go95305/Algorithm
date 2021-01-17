package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_캐시 {
    public int solution(int cacheSize, String[] cities) {

        int answer = 0;
        Queue<String> que = new LinkedList<>();

        //배열을 순서대로 탐색하면서 큐에 존재하는지 확인
        for (int i = 0; i < cities.length; i++) {
            String next = cities[i].toLowerCase();
            if (que.contains(next)) {
                answer += 1;
                que.remove(next);
            } else {
                answer += 5;
            }

            //큐의 사이즈가 cacheSize이면 맨처음에 들어간거 하나빼고 새것을 넣는다.
            if (cacheSize != 0) {
                if (que.size() == cacheSize) {
                    que.poll();
                }
                que.add(next);
            }


        }
        return answer;
    }

}
