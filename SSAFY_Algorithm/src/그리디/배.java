package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 배 {
    static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        List<Integer> crane = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        crane.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        int ans = 0;
        if (crane.get(0) < box.get(0)) {
            System.out.println(-1);
        } else {
            int time = 0;
            while (!box.isEmpty()) {
                int idx = 0;
                for (int i = 0; i < crane.size();) {
                    if (idx == box.size()) break;
                    else if (crane.get(i) >= box.get(idx)) {
                        box.remove(idx);
                    } else
                        idx++;
                }
                time++;
            }
            System.out.println(time);
        }



    }
}
