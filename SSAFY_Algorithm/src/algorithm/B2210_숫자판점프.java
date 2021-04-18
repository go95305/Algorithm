package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2210_숫자판점프 {
    static class Point {
        int r, c, cnt;
        String num;

        Point(int r, int c, int cnt, String num) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int map[][] = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Queue<Point> que = new LinkedList<>();
                que.add(new Point(i, j, 0, Integer.toString(map[i][j])));
                while (!que.isEmpty()) {
                    Point p = que.poll();
                    if (p.cnt == 5) {
                        int addList = Integer.parseInt(p.num);
                        if (!list.contains(addList))
                            list.add(addList);
                    }
                    for (int k = 0; k < 4; k++) {
                        int nr = p.r + dr[k];
                        int nc = p.c + dc[k];
                        if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && p.cnt < 5) {
                            que.add(new Point(nr, nc, p.cnt + 1, p.num + Integer.toString(map[nr][nc])));
                        }
                    }
                }
            }
        }

        System.out.println(list.size());
    }

}
