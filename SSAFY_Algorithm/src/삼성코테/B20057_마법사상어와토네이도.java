package 삼성코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B20057_마법사상어와토네이도 {
    static int N;
    static int map[][];
    static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};//상,우상,우,우하,하,좌하,좌,좌상
    static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static int movedr[] = {-1, 0, 1, 0};
    static int movedc[] = {0, 1, 0, -1};
    static int out;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r = N / 2;
        int c = N / 2;

        loop(r, c);
        System.out.println(out);


    }

    private static void loop(int r, int c) {
        //범위를 벗어날때까지 진행
        int dir = 6; // 초기 방향 <-
        int len = 1; //초기 길이
        //마지막 전까지는 두번씩 같은 길이로 실행
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < len; k++) {
                    r = r + dr[dir];
                    c = c + dc[dir];
                    move(dir, len, r, c);
//                    print();
                }
//                System.out.println("======방향 바꿈");
                dir -= 2;
                if (dir < 0)
                    dir = 6;
            }
            len++;
        }

        //마지막 한번 실행.
        for (int k = 0; k < len - 1; k++) {
            r = r + dr[dir];
            c = c + dc[dir];
            move(dir, len, r, c);

        }
    }

    private static void move(int dir, int len, int r, int c) {
        int value = map[r][c];

        int rightOne = (int) (value * (0.07));
        int rightTwo = (int) (value * (0.02));
        int leftOne = (int) (value * (0.07));
        int leftTwo = (int) (value * (0.02));
        int frontTwo = (int) (value * (0.05));
        int righttop = (int) (value * (0.1));
        int rightbottom = (int) (value * (0.01));
        int lefttop = (int) (value * (0.1));
        int leftbottom = (int) (value * (0.01));
        int total = rightOne + rightTwo + leftOne + leftTwo + frontTwo + righttop + rightbottom + lefttop + leftbottom;
//        System.out.println(total);
        int nr = 0;
        int nc = 0;
        int tmpDir = dir;
        tmpDir += 2;
        if (tmpDir > 7)
            tmpDir = 8 - tmpDir;

        // 우 1칸
        nr = r + dr[tmpDir];
        nc = c + dc[tmpDir];
        if (outOfRange(nr, nc))
            map[nr][nc] += rightOne;
        else
            out += rightOne;

        //우 2칸
        nr = r + dr[tmpDir] * 2;
        nc = c + dc[tmpDir] * 2;
        if (outOfRange(nr, nc))
            map[nr][nc] += rightTwo;
        else
            out += rightTwo;

        tmpDir = dir;
        tmpDir -= 2;
        if (tmpDir < 0)
            tmpDir = 8 + tmpDir;
        //좌 1칸
        nr = r + dr[tmpDir];
        nc = c + dc[tmpDir];
        if (outOfRange(nr, nc))
            map[nr][nc] += leftOne;
        else
            out += leftOne;

        //좌 2칸
        nr = r + dr[tmpDir] * 2;
        nc = c + dc[tmpDir] * 2;
        if (outOfRange(nr, nc))
            map[nr][nc] += leftTwo;
        else
            out += leftTwo;


        tmpDir = dir;
        tmpDir++;
        if (tmpDir == 8)
            tmpDir = 0;
        //우상 1칸
        nr = r + dr[tmpDir];
        nc = c + dc[tmpDir];
        if (outOfRange(nr, nc))
            map[nr][nc] += righttop;
        else
            out += righttop;

        tmpDir = dir;
        tmpDir += 3;
        if (tmpDir > 7)
            tmpDir = tmpDir - 8;
        //우하 1칸
        nr = r + dr[tmpDir];
        nc = c + dc[tmpDir];
        if (outOfRange(nr, nc))
            map[nr][nc] += rightbottom;
        else
            out += rightbottom;


        tmpDir = dir;
        tmpDir--;
        if (tmpDir == -1)
            tmpDir = 7;
        //좌상 1칸
        nr = r + dr[tmpDir];
        nc = c + dc[tmpDir];
        if (outOfRange(nr, nc))
            map[nr][nc] += lefttop;
        else
            out += lefttop;


        tmpDir = dir;
        tmpDir -= 3;
        //좌하 1칸
        if (tmpDir < 0)
            tmpDir = 8 + tmpDir;
        nr = r + dr[tmpDir];
        nc = c + dc[tmpDir];
        if (outOfRange(nr, nc))
            map[nr][nc] += leftbottom;
        else
            out += leftbottom;

        //점프
        nr = r + dr[dir] * 2;
        nc = c + dc[dir] * 2;
        if (outOfRange(nr, nc))
            map[nr][nc] += frontTwo;
        else
            out += frontTwo;

        //a
        nr = r + dr[dir];
        nc = c + dc[dir];
        if (outOfRange(nr, nc))
            map[nr][nc] += value - total;
        else
            out += (value - total);

    }

    private static boolean outOfRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < N)
            return true;
        return false;
    }

    private static void print() {
        for (int i = 0; i < N; i++)
            System.out.println(Arrays.toString(map[i]));
        System.out.println();
    }
}
