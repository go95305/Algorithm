package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20055_컨베이어벨트위의로봇_re {
    static int N, K;
    static int map[];
    static int v[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[2 * N];//내구도
        v = new int[N];// 로봇 존재 여부
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 2 * N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        int turn = 1;
        int robot = 1;
        while (true) {

            circular();
            //2. 각 칸의 로봇을 이동(내구도 범위 안에서) 로봇을 넣은 순서대로!
            for (int i = N - 2; i >= 0; i--) {
                if (v[i] == 1 && v[i + 1] == 0 && map[i + 1] > 0) {
                    map[i + 1]--;
                    v[i + 1] = v[i];
                    v[i] = 0;
                }
                if (v[N - 1] == 1)
                    v[N - 1] = 0;
            }

            //만약 1번 칸에 로봇이 없으면 올린다. 물론 내구도가 있으면
            if (map[0] > 0 && v[0] == 0) {
                v[0] = robot;
                map[0]--;
            }


            //내구도 개수 확인
            int cnt = countLife();
            if (cnt >= K)
                break;
            turn++;

        }
        System.out.println(turn);
    }

    private static void circular() {
        for (int i = N - 2; i >= 0; i--) {
            if (v[i] == 1) {
                v[i + 1] = v[i];
                v[i] = 0;
            }
        }

        if (v[N - 1] > 0)
            v[N - 1] = 0;

        int tmp = map[map.length - 1];
        for (int i = map.length - 1; i > 0; i--) {
            map[i] = map[i - 1];
        }
        map[0] = tmp;
    }


    private static int countLife() {
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0)
                cnt++;
        }
        return cnt;
    }
}
