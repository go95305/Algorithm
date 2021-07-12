package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2610_회의준비 {
    static int N, M;
    static int map[][];
    static boolean v[];
    static int gCnt;
    static int connection;
    static int smallIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int INF = 99999999;
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], INF);
        }
        List<Integer>[] list = new ArrayList[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            map[from][to] = 1;
            map[to][from] = 1;
            list[from].add(to);
            list[to].add(from);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (i == k) continue;
                for (int j = 0; j < N; j++) {
                    if (i == j || j == k) continue;
                    if (map[i][k] + map[k][j] < map[i][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == INF)
                    map[i][j] = 0;
            }
        }

        int maxPath[] = new int[N];
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 0; j < N; j++) {
                max = Math.max(max, map[i][j]);
            }
            maxPath[i] = max;
        }

        v = new boolean[N];
        List<Integer> answer = new ArrayList<>();
        /** 탐색을 통해 그룹을 나눈다.*/
        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                connection = Integer.MAX_VALUE;
                smallIdx = 0;
                gCnt++;
                v[i] = true;
                dfs(i, list, maxPath);
                answer.add(smallIdx + 1);
            }
        }

        Collections.sort(answer);
        System.out.println(gCnt);
        for (int i = 0; i < answer.size(); i++)
            System.out.println(answer.get(i));
    }

    private static void dfs(int idx, List<Integer>[] list, int[] maxPath) {
        //현재 노드의 연결된 그룹간의 거리구하기
        if (connection > maxPath[idx]) {
            connection = maxPath[idx];
            smallIdx = idx;
        } else if (connection == maxPath[idx]) {
            if (smallIdx > idx)
                smallIdx = idx;
        }
        //연결된 노드로 이동
        int size = list[idx].size();
        if (size == 0)
            return;

        for (int i = 0; i < size; i++) {
            int num = list[idx].get(i);
            if (!v[num]) {
                v[num] = true;
                dfs(num, list, maxPath);
            }
        }
    }
}
