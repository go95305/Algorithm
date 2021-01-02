package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_다리를지나는트럭 {
    static class Point {
        int value, time;

        Point(int value, int time) {
            this.value = value;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        Queue<Point> que = new LinkedList<>();
        int crossed = 0;
        int curr = 0;
        int totalWeight = 0;
        int truckIdx = 0;
        while (crossed < truck_weights.length) {
            curr++;

            //현재 curr과 객체의 curr+ bridge_length가 같으면 Poll해준다.
            if (!que.isEmpty() && bridge_length + que.peek().time == curr) {
                totalWeight -= que.peek().value;
                que.poll();
                crossed++;
            }
            //총weight보다 작으면 que에 넣는다.
            if (truckIdx < truck_weights.length && totalWeight + truck_weights[truckIdx] <= weight) {
                que.add(new Point(truck_weights[truckIdx], curr));
                totalWeight += truck_weights[truckIdx];
                truckIdx++;
            }
        }
        System.out.println(curr);
    }
}
