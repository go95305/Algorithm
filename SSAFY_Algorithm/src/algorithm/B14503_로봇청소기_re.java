package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14503_로봇청소기_re {
    static int N, M;
    static int map[][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static boolean v[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];
        /** 로봇 청소기의  시작 위치 및 방향*/
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean flag = true;
        int ans = 0;

        while (flag) {
            //현재 장소 청소
            v[r][c] = true;
            ans++;
            while (true) {
                //현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
                int tmpDir = dir;
                boolean isClean = false;
                for (int k = 0; k < 4; k++) {
                    tmpDir--;
                    if (tmpDir < 0)
                        tmpDir = 3;
                    int tmpR = r + dr[tmpDir];
                    int tmpC = c + dc[tmpDir];
                    if (tmpR > 0 && tmpR < N - 1 && tmpC > 0 && tmpC < M - 1 && map[tmpR][tmpC] == 0) {
                        if (!v[tmpR][tmpC]) {
                            r = tmpR;
                            c = tmpC;
                            dir = tmpDir;
                            isClean = true;
                            break;
                        }
                    }
                }
                //4칸다 모두 이동불가능할 경우
                if (!isClean) {
                    //후진 가능한지 확인
                    int back = dir - 2;
                    if (back < 0)
                        back += 4;

                    int nr = r + dr[back];
                    int nc = c + dc[back];
                    if (nr > 0 && nr < N - 1 && nc > 0 && nc < M - 1 && map[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
