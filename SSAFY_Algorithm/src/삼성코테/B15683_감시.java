package 삼성코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B15683_감시 {
    static int N, M;
    static char map[][];
    static boolean v[][];
    static List<Point> list;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int ans;

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = new boolean[N][M];
        map = new char[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] != '0' && map[i][j] != '6')
                    list.add(new Point(i, j));
            }
        }


        ans = Integer.MAX_VALUE;
        char copy[][] = new char[N][M];
        boolean visit[][] = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
            visit[i] = v[i].clone();
        }
        dfs(copy, visit, 0);
        System.out.println(ans);
    }

    private static void dfs(char[][] arr, boolean[][] vi, int depth) {
        if (depth == list.size()) {
//            print(arr);
            ans = Math.min(ans, getMin(arr));
            return;
        }



        for (int i = 0; i < list.size(); i++) {
            Point p = list.get(i);
            if (!vi[p.r][p.c]) {
                if (arr[p.r][p.c] == '1') {
                    for (int k = 0; k < 4; k++) {
                        char[][] copy = new char[N][M];
                        boolean[][] visit = new boolean[N][M];
                        for (int j = 0; j < N; j++) {
                            copy[j] = arr[j].clone();
                            visit[j] = vi[j].clone();
                        }
                        visit[p.r][p.c] = true;
                        setOne(copy, visit, k, p.r, p.c);
                        dfs(copy, visit, depth + 1);
                        visit[p.r][p.c] = false;
                    }
                } else if (map[p.r][p.c] == '2') {
                    for (int k = 0; k < 2; k++) {
                        char[][] copy = new char[N][M];
                        boolean[][] visit = new boolean[N][M];
                        for (int j = 0; j < N; j++) {
                            copy[j] = arr[j].clone();
                            visit[j] = vi[j].clone();
                        }
                        visit[p.r][p.c] = true;
                        setTwoOrThree(copy, visit, k, p.r, p.c, 2);
                        dfs(copy, visit, depth + 1);
                        visit[p.r][p.c] = false;
                    }
                } else if (map[p.r][p.c] == '3') {
                    for (int k = 0; k < 4; k += 2) {
                        char[][] copy = new char[N][M];
                        boolean[][] visit = new boolean[N][M];
                        for (int j = 0; j < N; j++) {
                            copy[j] = arr[j].clone();
                            visit[j] = vi[j].clone();
                        }
                        visit[p.r][p.c] = true;
                        setTwoOrThree(copy, visit, k, p.r, p.c, 3);
                        dfs(copy, visit, depth + 1);
                        visit[p.r][p.c] = false;
                    }
                } else if (map[p.r][p.c] == '4') {
                    for (int k = 0; k < 4; k++) {
                        char[][] copy = new char[N][M];
                        boolean[][] visit = new boolean[N][M];
                        for (int j = 0; j < N; j++) {
                            copy[j] = arr[j].clone();
                            visit[j] = vi[j].clone();
                        }
                        visit[p.r][p.c] = true;
                        setFour(copy, visit, k, p.r, p.c);
                        dfs(copy, visit, depth + 1);
                        visit[p.r][p.c] = false;
                    }
                } else {
                    char[][] copy = new char[N][M];
                    boolean[][] visit = new boolean[N][M];
                    for (int j = 0; j < N; j++) {
                        copy[j] = arr[j].clone();
                        visit[j] = vi[j].clone();
                    }
                    visit[p.r][p.c] = true;
                    setFive(copy, visit, p.r, p.c);
                    dfs(copy, visit, depth + 1);
                    visit[p.r][p.c] = false;
                }
            }
        }
    }

    private static void print(char[][] arr) {
        for (int i = 0; i < N; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println();
    }

    private static int getMin(char[][] arr) {
        int size = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == '0')
                    size++;
            }
        }
        return size;
    }

    private static void setFive(char[][] copy, boolean[][] visit, int r, int c) {
        for (int i = 1; i <= 8; i++) {
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k] * i;
                int nc = c + dc[k] * i;
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (copy[nr][nc] == '0') {
                        copy[nr][nc] = '#';
                        visit[nr][nc] = true;
                    } else
                        break;
                }
            }
        }
    }

    private static void setFour(char[][] copy, boolean[][] visit, int k, int r, int c) {
        int str = r;
        int stc = c;
        int front = k;
        int left = k - 1;
        if (left == 0)
            left = 3;
        int right = k + 1;
        if (right == 4)
            right = 0;
        while (true) {
            int nr = r + dr[left];
            int nc = c + dc[left];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (copy[nr][nc] == '0') {
                    copy[nr][nc] = '#';
                    visit[nr][nc] = true;
                } else
                    break;
                r = nr;
                c = nc;
            } else {
                break;
            }
        }

        r = str;
        c = stc;
        while (true) {
            int nr = r + dr[front];
            int nc = c + dc[front];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (copy[nr][nc] == '0') {
                    copy[nr][nc] = '#';
                    visit[nr][nc] = true;
                } else
                    break;
                r = nr;
                c = nc;
            } else {
                break;
            }
        }
        while (true) {
            int nr = r + dr[right];
            int nc = c + dc[right];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (copy[nr][nc] == '0') {
                    copy[nr][nc] = '#';
                    visit[nr][nc] = true;
                } else
                    break;
                r = nr;
                c = nc;
            } else {
                break;
            }
        }

    }

    private static void setTwoOrThree(char[][] copy, boolean[][] visit, int k, int r, int c, int num) {
        int str = r;
        int stc = c;
        while (true) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (copy[nr][nc] == '0') {
                    copy[nr][nc] = '#';
                    visit[nr][nc] = true;
                } else
                    break;
                r = nr;
                c = nc;
            } else {
                break;
            }
        }

        if (num == 2)
            k += 2;
        else
            k++;

        r = str;
        c = stc;
        while (true) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (copy[nr][nc] == '0') {
                    copy[nr][nc] = '#';
                    visit[nr][nc] = true;
                } else
                    break;
                r = nr;
                c = nc;
            } else {
                return;
            }
        }
    }

    private static void setOne(char[][] copy, boolean[][] visit, int k, int r, int c) {
        while (true) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (copy[nr][nc] == '0') {
                    copy[nr][nc] = '#';
                    visit[nr][nc] = true;
                } else
                    break;
                r = nr;
                c = nc;
            } else {
                return;
            }
        }
    }


}
