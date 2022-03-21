package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 기차가어둠을해치고은하수를 {
    static int N, M;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][20];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken()) - 1;
            int seat = 0;
            if (order == 1 || order == 2) {
                seat = Integer.parseInt(st.nextToken()) - 1;
                if (order == 1) {
                    if (map[train][seat] == 0)
                        map[train][seat] = 1;
                } else {
                    if (map[train][seat] == 1)
                        map[train][seat] = 0;
                }
            } else if (order == 3) {
                addSeat(train);
            } else {
                subSeat(train);
            }

        }

        int v[] = new int[20];
        int answer = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < 20; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                    if (v[j] == 0) {
                        v[j] = i + 1;
                    }
                }
            }
            if (cnt == 0)
                flag = true;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Arrays.toString(map[i]));
        }
        System.out.println(set.size());


    }

    private static void subSeat(int train) {
        for (int i = 0; i < 19; i++) {
            map[train][i] = map[train][i+1];
        }
        map[train][19]=0;
    }

    private static void addSeat(int train) {
        for (int i = map[train].length - 1; i > 0; i--) {
            map[train][i] = map[train][i - 1];
        }
        map[train][0] = 0;
    }
}

