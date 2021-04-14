package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B17140_이차원배열과연산 {
    static class Point implements Comparable<Point> {
        int num, idxCnt;

        Point(int num, int idxCnt) {
            this.num = num;
            this.idxCnt = idxCnt;
        }


        @Override
        public int compareTo(Point o) {
            if (o.idxCnt == this.idxCnt)
                return this.num - o.num;
            return this.idxCnt - o.idxCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int map[][] = new int[100][100];
        int R = 3;
        int C = 3;
        int time = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt[] = null;
        while (map[r][c] != k && time <= 100) {
            //R>=C인 경우
            if (R >= C) {
                //index개수를 구할 배열 선언

                int longC = 0;
                for (int i = 0; i < R; i++) {
                    cnt = new int[101];
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] != 0) {
                            cnt[map[i][j]]++;
                        }
                    }

                    //한행 끝나면 정렬
                    PriorityQueue<Point> que = new PriorityQueue<>();
                    //우선 PriorityQue에 넣어서 정렬 시킨다.
                    for (int j = 1; j < cnt.length; j++) {
                        if (cnt[j] != 0) {
                            que.add(new Point(j, cnt[j]));
                        }
                    }
                    //que에서 빼면서 배열에 넣는다.
                    int putIdx = 0;
                    while (!que.isEmpty()) {
                        Point p = que.poll();
                        map[i][putIdx++] = p.num;
                        map[i][putIdx++] = p.idxCnt;
                    }
                    //그 행의 뒤의 값은 전부 0 처리
                    putZeroRow(map, putIdx, i);
                    //배열에 업데이트 및 최장길이행 체크(R 수정)
                    longC = Math.max(longC, putIdx);
                }
                C = longC;

            } else {
                //C<R인 경우
                int longR = 0;
                for (int i = 0; i < C; i++) {
                    cnt = new int[101];
                    for (int j = 0; j < R; j++) {
                        if (map[j][i] != 0) {
                            cnt[map[j][i]]++;
                        }
                    }

                    //한행 끝나면 정렬
                    PriorityQueue<Point> que = new PriorityQueue<>();
                    //우선 PriorityQue에 넣어서 정렬 시킨다.
                    for (int j = 1; j < cnt.length; j++) {
                        if (cnt[j] != 0) {
                            que.add(new Point(j, cnt[j]));
                        }
                    }
                    //que에서 빼면서 배열에 넣는다.
                    int putIdx = 0;
                    while (!que.isEmpty()) {
                        Point p = que.poll();
                        map[putIdx++][i] = p.num;
                        map[putIdx++][i] = p.idxCnt;
                    }
                    //그 행의 뒤의 값은 전부 0 처리
                    putZeroCol(map, putIdx, i);
                    //배열에 업데이트 및 최장길이행 체크(R 수정)
                    longR = Math.max(longR, putIdx);
                }
                R = longR;

            }

            time++;

        }
        if (time > 100)
            System.out.println(-1);
        else
            System.out.println(time);

    }

    private static void putZeroCol(int[][] map, int putIdx, int idx) {
        for (int j = putIdx; j < map.length; j++) {
            map[j][idx] = 0;
        }
    }

    private static void putZeroRow(int[][] map, int putIdx, int idx) {
        for (int j = putIdx; j < map.length; j++) {
            map[idx][j] = 0;
        }
    }

}
