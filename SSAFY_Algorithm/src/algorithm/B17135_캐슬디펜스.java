package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17135_캐슬디펜스 {
    static int N, M, D;
    static int map[][];
    static boolean archer[];
    static int targetDist;
    static int targetR;
    static int targetC;
    static int ans;
    static int copy[][];

    static class Point {
        int r, c, dist;

        Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        archer = new boolean[M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        combination(0, 0);
        System.out.println(ans);

    }

    private static void combination(int idx, int k) {
        if (k == 3) {
            int turn = N;
            List<Point> list = new ArrayList<>();
            setList(list);
            copy = new int[N][M];
            copyMap(copy);
            int kill = 0;
            while (turn > 0) {
                List<Point> remove = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    targetC = 0;
                    targetR = 0;
                    targetDist = Integer.MAX_VALUE;
                    searchTarget(list.get(i).r, list.get(i).c);
                    if (targetDist != Integer.MAX_VALUE) {//해당 턴에 한명이상 죽일수있으면

                        Point p = new Point(targetR, targetC, 0);
                        if (!remove.contains(p))
                            remove.add(new Point(targetR, targetC, 0));
                    }
                }
                //적 제거
                for (int i = 0; i < remove.size(); i++) {
                    Point p = remove.get(i);
                    if (copy[p.r][p.c] != 0) {
                        copy[p.r][p.c] = 0;
                        kill++;
                    }
                }
                //한칸 내리기
                movingEnemy();

                turn--;
            }
            ans = Math.max(ans, kill);
            return;
        }

        for (int i = idx; i < M; i++) {
            archer[i] = true;
            combination(i + 1, k + 1);
            archer[i] = false;
        }
    }

    private static void copyMap(int[][] copy) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }

    private static void movingEnemy() {
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = copy[i - 1][j];
            }
        }
        for (int i = 0; i < M; i++) {
            copy[0][i] = 0;
        }
    }

    private static void searchTarget(int r, int c) {
        //현재 궁수 좌표에서 잡을 수 있는 적 큐에넣기
        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int dist = Math.abs(r - i) + Math.abs(c - j);
                if (dist <= D && copy[i][j] == 1) {
                    que.add(new Point(i, j, dist));
                }
            }
        }
        //que를 돌면서 죽일 적 선정
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (targetDist == p.dist) {
                if (targetC > p.c) {
                    targetC = p.c;
                    targetR = p.r;
                }
            } else if (targetDist > p.dist) {
                targetDist = p.dist;
                targetC = p.c;
                targetR = p.r;
            }
        }
    }

    private static void setList(List<Point> list) {
        for (int i = 0; i < archer.length; i++) {
            if (archer[i]) {
                list.add(new Point(N, i, 0));
            }
        }
    }
}
