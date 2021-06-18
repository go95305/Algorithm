package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17136_색종이붙이기_re {
    static int map[][];
    static int paper[];
    static int ans;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[10][10];
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    cnt++;
            }
        }
        ans = Integer.MAX_VALUE;
        paper = new int[5];
        Arrays.fill(paper, 5);
        boolean v[][] = new boolean[10][10];
        search(v, 0, cnt);
        if (ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);

    }

    private static void search(boolean[][] v, int paperCnt, int cnt) {
        flag=false;
        if (cnt == 0) {
            ans = Math.min(ans, paperCnt);
            return;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1 && !v[i][j]) {
                    for (int k = 5; k >= 1; k--) {
                        if (paper[k - 1] > 0 && isCover(i, j, k, v)) {
                            boolean b[][] = new boolean[10][];
                            for (int a = 0; a < 10; a++) {
                                b[a] = v[a].clone();
                            }
                            coverUp(i, j, k, b);
                            paper[k - 1]--;
                            search(b, paperCnt + 1, cnt - (k * k));
                            paper[k - 1]++;
                        }
                    }
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }


    }

    private static void coverUp(int r, int c, int k, boolean[][] v) {
        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                v[i][j] = true;
            }
        }
    }

    private static boolean isCover(int r, int c, int size, boolean[][] b) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (i > 9 || j > 9 || b[i][j] || map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
