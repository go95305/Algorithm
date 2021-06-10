package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17281_공 {
    static int inning;
    static int map[][];
    static boolean v[];
    static int sel[];
    static int ans;

    static class Player {
        int hit, number;

        Player(int hit, int number) {
            this.hit = hit;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        inning = Integer.parseInt(st.nextToken());
        map = new int[inning][9];

        for (int i = 0; i < inning; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        v = new boolean[9];
        sel = new int[9];
        ans = 0;

        sel[3]=0;
        v[3]=true;
        //순열 돌리기
        permutation(1);
        System.out.println(ans);


    }

    private static void permutation(int k) {
        if (k == v.length) {
//            System.out.println(Arrays.toString(sel));
            getScore();
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!v[i]) {
                v[i] = true;
                sel[i] = k;
                permutation(k + 1);
                v[i] = false;
            }
        }
    }

    private static void getScore() {
        int inningCnt = 0;
        int totalScore = 0;
        int out = 0;
        int listCnt = 0;


//        System.out.println(Arrays.toString(sel));
        while (inningCnt < inning) {
            boolean flag = true;
            boolean[] board = new boolean[3];
            Player[] position = new Player[9];
            for (int i = 0; i < sel.length; i++) {
                position[i] = new Player(map[inningCnt][sel[i]], sel[i]);
            }
//            if (position[3].number != 0) { //1번선수가 4번타자로 매번 설정
//                replace(position);
//            }
            while (flag) {
                //이전 선수 찾았으면 그다음 선수를 찾아서 p에 할당. 지금은 그냥 인덱스로 할당해버림
                Player p = position[listCnt];

                if (p.hit < 4 && p.hit > 0) {
                    for (int i = 2; i >= 0; i--) {
                        if (board[i]) {
                            board[i] = false;
                            if (i + p.hit > 2) { //범위 나가면 총점 ++;
                                totalScore++;
                            } else {
                                board[i + p.hit] = true;
                            }
                        }
                    }
                    board[p.hit - 1] = true;//기존 주자 앞으로 보내고 다음에 방금 안타친 사람 이동.
                } else if (p.hit == 4) {
                    int cnt = 0;
                    for (int i = 0; i < 3; i++) {
                        if (board[i]) {
                            cnt++;
                            board[i] = false;
                        }
                    }
                    totalScore += cnt + 1;
                } else {
                    out++;
                    if (out == 3) {
                        out = 0;
                        board = new boolean[3];
                        flag = false;
                    }
                }
                listCnt++;
                if (listCnt > 8)
                    listCnt = 0;
            }
            inningCnt++;// 다음 이닝
        }
        //점수 최대값 구하기
        ans = Math.max(ans, totalScore);
    }


    private static void replace(Player[] position) {
        for (int i = 0; i < position.length; i++) {
            if (position[i].number == 0) {
                Player p = position[3];
                position[3] = position[i];
                position[i] = p;
                break;
            }
        }
    }
}
