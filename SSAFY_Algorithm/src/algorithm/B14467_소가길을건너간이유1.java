package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14467_소가길을건너간이유1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int map[][] = new int[N][2];
        boolean v[] = new boolean[N];
        int cross = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cow = Integer.parseInt(st.nextToken()) - 1;
            int move = Integer.parseInt(st.nextToken());
            //소가 아직 처음 자리인지 확인
            if (!v[cow]) {
                map[cow][0] = move;
                v[cow] = true;
            } else {
                if (map[cow][0] != move) {
                    map[cow][1]++;
                    map[cow][0] = move;
                }
            }
            if (map[cow][1] == 1) {
                map[cow][1] = 0;
                cross++;
            }

        }
        System.out.println(cross);
    }
}
