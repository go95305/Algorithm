package algorithm;

import java.util.*;

public class B19238_스타트택시 {
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static boolean v[][];
    static int map[][];
    static int N, M;
    static int xx, yy;
    static int ans;
    static int ddgas;

    static class Destination {
        int r, c, num;

        Destination(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }

    static class Point implements Comparable<Point> {
        int r, c, cnt, gas;

        Point(int r, int c, int cnt, int gas) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.gas = gas;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    ", cnt=" + cnt +
                    ", gas=" + gas +
                    '}';
        }

        @Override
        public int compareTo(Point o) {
            if (this.cnt > o.cnt)
                return 1;
            else if (this.cnt < o.cnt)
                return -1;
            else {
                if (this.r > o.r)
                    return 1;
                else if (this.r < o.r)
                    return -1;
                else {
                    if (this.c > o.c)
                        return 1;
                    else
                        return -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt(); //승객수
        int gas = sc.nextInt(); //초기 가스
        map = new int[N][N];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        List<Destination> list = new ArrayList<>();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        for (int i = 2; i <= M + 1; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r - 1][c - 1] = i;
            int destx = sc.nextInt() - 1;
            int desty = sc.nextInt() - 1;
            list.add(new Destination(destx, desty, i));
        }
        int cGoal = 0;
        Point start = searchNext(x, y, gas);
        if (start != null) {
//            System.out.println(start);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).num == map[start.r][start.c]) {
                    cGoal = list.get(i).num;
                }
            }
            v = new boolean[N][N];
            Queue<Point> que = new LinkedList<>();
            que.add(new Point(x, y, 0, gas));
            v[x][y] = true;
            while (!que.isEmpty()) {
                Point p = que.poll();
//                System.out.println(p);
                if (map[p.r][p.c] == cGoal) {

                    map[p.r][p.c] = 0;
                    //목적지 찾는 메소드 실행
                    int nx = p.r;
                    int ny = p.c;
                    int mx = 0;
                    int my = 0;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).num == cGoal) {
                            mx = list.get(i).r;
                            my = list.get(i).c;
                        }
                    }
//                    System.out.println("출발점" + nx + "-" + ny);
//                    System.out.println("도착점" + mx + "-" + my);
//                    System.out.println("충전전 가스" + p.gas);
                    Point nextp = searchDest(nx, ny, mx, my, p.gas);
                    if (nextp == null)
                        break;
                    if (ans == M)
                        break;
//                    System.out.println("충전후 가스" + nextp.gas);

                    //다음 사람찾기 메소드
                    que.clear();
                    p = new Point(xx, yy, 0, nextp.gas);
                    que.add(p);
//                    System.out.println("xx yy" + xx + ":" + yy);
//                    System.out.println("새로운 시작점:" + p.r + "-" + p.c);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).num == map[nextp.r][nextp.c]) {
                            cGoal = list.get(i).num;
                        }
                    }
//                    System.out.println("새로운 도착점 :" + cGoal);
                    v = new boolean[N][N];
                    v[xx][yy] = true;
                }
                if (ans == M)
                    break;

                for (int k = 0; k < 4; k++) {
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1 && !v[nr][nc] && p.gas > 0) {
                        v[nr][nc] = true;
                        que.add(new Point(nr, nc, 0, p.gas - 1));
                    }
                }
            }
        }
        if (ans != M) {
            System.out.println("-1");
        } else
            System.out.println(ddgas);
    }

    private static Point searchDest(int nx, int ny, int mx, int my, int gas) {
        v = new boolean[N][N];
        Point nextp = null;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(nx, ny, 0, gas));
        v[nx][ny] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();
//            System.out.println(p.gas);
            if (p.r == mx && p.c == my) {
                ans++;
                xx = p.r;
                yy = p.c;
                int newgas = p.gas + (p.cnt * 2);
                ddgas = newgas;
                if (ans == M)
                    return null;
//                System.out.println(newgas);
                nextp = searchNext(mx, my, newgas);
                break;
            }
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1 && !v[nr][nc] && p.gas > 0) {
                    v[nr][nc] = true;
                    que.add(new Point(nr, nc, p.cnt + 1, p.gas - 1));
                }
            }
        }

        return nextp;

    }

    private static Point searchNext(int mx, int my, int gas) {
        Point target = null;
        PriorityQueue<Point> que = new PriorityQueue<>();
        v = new boolean[N][N];
        que.add(new Point(mx, my, 0, gas));
        v[mx][my] = true;
        int nextCnt = Integer.MAX_VALUE;
        int next = Integer.MAX_VALUE;
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (map[p.r][p.c] > 1) {

                target = new Point(p.r, p.c, 0, p.gas);
                break;

            }
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1 && !v[nr][nc]) {
                    v[nr][nc] = true;
                    que.add(new Point(nr, nc, p.cnt + 1, p.gas));
                }
            }
        }
        return target;
    }
}
