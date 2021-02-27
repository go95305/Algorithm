package algorithm;

import java.util.*;

public class B11000_강의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int room[][] = new int[N][2];
        for (int i = 0; i < N; i++) {
            room[i][0] = sc.nextInt();
            room[i][1] = sc.nextInt();
        }

        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(room[0][1]);

        for (int i = 1; i < N; i++) {
            if(room[i][0]<pq.peek()){
                pq.add(room[i][1]);
            }else{
                pq.poll();
                pq.add(room[i][1]);
            }
        }
        System.out.println(pq.size());

    }
}
