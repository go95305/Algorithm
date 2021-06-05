package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13459_구슬탈출 {
    static int N, M;
    static char map[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static boolean v[][][][];

    static class Point {
        int blue[];
        int red[];

        Point(int blue[], int red[]) {
            this.blue = blue;
            this.red = red;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        Queue<Point> que = new LinkedList<>();
        v = new boolean[N][M][N][M];
        int blue[];
        blue = new int[2];
        int red[];
        red = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
                if (map[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                }

            }
        }
        que.add(new Point(blue, red));

        v[red[0]][red[1]][blue[0]][blue[1]] = true;
        System.out.println(bfs(que));
    }

    private static int bfs(Queue<Point> que) {
        int cnt = 0;
        while (!que.isEmpty() && cnt < 10) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point p = que.poll();
                for (int k = 0; k < 4; k++) {
                    int[] red = p.red.clone(); // 깊은 복사를 해야 매번 값이 바뀌지 않는다.
                    int[] blue = p.blue.clone();

                    /*
                    1. 해당 방향에서 어느 공이 앞에있는 지를 확인
                    2. 각 공을 이동시킨다.
                       2-1 #이나 O에 도착하면 멈춤
                    3. 만약 파란 공이 O이면 실패!
                    4. 각공을 이동하고 나면 같은 위치에 있을수도 있으므로 방향별 위치 조정.
                    5. 이 단계가지 진행했다면 true를 반환.
                     */
                    if (move(red, blue, k)) {
                        if (map[red[0]][red[1]] == 'O') { // 여기 들어왔다는것은 파란공은 무조건 O에 있지 않음을 의미.
                            return 1;
                        }
                        if (v[red[0]][red[1]][blue[0]][blue[1]])
                            continue;
                        v[red[0]][red[1]][blue[0]][blue[1]] = true;
                        que.add(new Point(blue, red));
                    }
                }
            }
            cnt++;
        }
        return 0;
    }

    private static boolean move(int[] red, int[] blue, int k) {
        boolean redFirst = false;
        if (k == 0 && red[0] < blue[0])
            redFirst = true;
        if (k == 1 && red[0] > blue[0])
            redFirst = true;
        if (k == 2 && red[1] < blue[1])
            redFirst = true;
        if (k == 3 && red[1] > blue[1])
            redFirst = true;

        int nr = red[0];
        int nc = red[1];
        while (true) {
            nr += dr[k];
            nc += dc[k];
            if (map[nr][nc] == '#') break;
            red[0] = nr;
            red[1] = nc;
            if (map[nr][nc] == 'O')
                break;
        }

        nr = blue[0];
        nc = blue[1];
        while (true) {
            nr += dr[k];
            nc += dc[k];
            if (map[nr][nc] == '#') break;
            blue[0] = nr;
            blue[1] = nc;
            if (map[nr][nc] == 'O')
                break;
        }

        if (map[blue[0]][blue[1]] == 'O')
            return false;


        if (red[0] == blue[0] && red[1] == blue[1]) { // 각자 이동후 같은 위치도 도달했으면?
            switch (k) {
                case 0:
                    if (redFirst) {
                        blue[0]++;
                    } else
                        red[0]++;
                    break;
                case 1:
                    if (redFirst)
                        blue[0]--;
                    else
                        red[0]--;
                    break;
                case 2:
                    if (redFirst)
                        blue[1]++;
                    else
                        red[1]++;
                    break;
                case 3:
                    if (redFirst)
                        blue[1]--;
                    else
                        red[1]--;
            }
        }

        return true;
    }

}
