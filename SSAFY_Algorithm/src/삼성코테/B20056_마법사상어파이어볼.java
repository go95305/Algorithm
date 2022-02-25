package 삼성코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B20056_마법사상어파이어볼 {
    static int N, M, K;
    static int map[][];
    static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};//상,우상,우,우하,하,좌하,좌,좌상
    static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Point {
        int r, c, m, s, d;

        Point(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    ", m=" + m +
                    ", s=" + s +
                    ", d=" + d +
                    '}';
        }
    }

    static class fireball {
        int r, c, msum, ssum, evenD, oddD, cnt, curDir;

        fireball(int r, int c, int msum, int ssum, int evenD, int oddD, int cnt, int curDir) {
            this.r = r;
            this.c = c;
            this.msum = msum;
            this.ssum = ssum;
            this.evenD = evenD;
            this.oddD = oddD;
            this.cnt = cnt;
            this.curDir = curDir;
        }

        @Override
        public String toString() {
            return "fireball{" +
                    "r=" + r +
                    ", c=" + c +
                    ", msum=" + msum +
                    ", ssum=" + ssum +
                    ", evenD=" + evenD +
                    ", oddD=" + oddD +
                    ", cnt=" + cnt +
                    ", curDir=" + curDir +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            que.add(new Point(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
//            System.out.println(que);
            fireball fb[][] = move(que);
            //파이어볼을 분리한다.
            que = setNewFireball(fb);
        }

        int ans = getAllMass(que);
        System.out.println(ans);
    }

    private static int getAllMass(Queue<Point> que) {
        int sum = 0;
        while (!que.isEmpty()) {

            Point p = que.poll();
            sum += p.m;
        }
        return sum;
    }

    private static Queue<Point> setNewFireball(fireball[][] fb) {

//        for (int i = 0; i < N; i++)
//            System.out.println(Arrays.toString(fb[i]));
        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (fb[i][j] != null) {
                    fireball fire = fb[i][j];
                    if (fire.cnt == 1) {
                        que.add(new Point(fire.r, fire.c, fire.msum, fire.ssum, fire.curDir));
                    } else {
                        int mass = fire.msum / 5;
                        int speed = fire.ssum / fire.cnt;
                        if (fire.evenD > 0 && fire.oddD > 0) {
                            if (mass > 0) {
                                que.add(new Point(fire.r, fire.c, mass, speed, 1));
                                que.add(new Point(fire.r, fire.c, mass, speed, 3));
                                que.add(new Point(fire.r, fire.c, mass, speed, 5));
                                que.add(new Point(fire.r, fire.c, mass, speed, 7));
                            }
                        } else {
                            if (mass > 0) {
                                que.add(new Point(fire.r, fire.c, mass, speed, 0));
                                que.add(new Point(fire.r, fire.c, mass, speed, 2));
                                que.add(new Point(fire.r, fire.c, mass, speed, 4));
                                que.add(new Point(fire.r, fire.c, mass, speed, 6));
                            }
                        }
                    }
                }
            }
        }
        return que;
    }

    private static fireball[][] move(Queue<Point> que) {
        fireball[][] tmpMap = new fireball[N][N];
        while (!que.isEmpty()) {
            int oddD = 0;
            int evenD = 0;
            Point p = que.poll();

            int dir = p.d;
            if (dir % 2 == 0)
                evenD++;
            else
                oddD++;

            int nr = p.r + dr[dir] * p.s;
            int nc = p.c + dc[dir] * p.s;

            if (nr < 0) {
                while (nr < 0)
                    nr = nr + N;
            } else if (nr >= N) {
                while (nr >= N)
                    nr = nr - N;
            }

            if (nc < 0) {
                while (nc < 0)
                    nc = N + nc;
            } else if (nc >= N) {
                while (nc >= N)
                    nc = nc - N;
            }

            if (tmpMap[nr][nc] == null) {
                tmpMap[nr][nc] = new fireball(nr, nc, p.m, p.s, evenD, oddD, 1, p.d);
            } else {
                fireball origin = tmpMap[nr][nc];
                tmpMap[nr][nc] = new fireball(nr, nc, p.m + origin.msum, origin.ssum + p.s, evenD + origin.evenD, oddD + origin.oddD, origin.cnt + 1, 0);
            }


        }


        return tmpMap;
    }
}
