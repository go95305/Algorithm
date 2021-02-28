package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class B5014_스타트링크 {
    static class Step {
        int cur, cnt;

        Step(int cur, int cnt) {
            this.cur = cur;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;

        boolean v[] = new boolean[1000002];
        Queue<Step> que = new LinkedList<>();
        que.add(new Step(S, 0));
        v[S] = true;

        boolean isAns = false;
        //애초에 갈수 있는지 없는지를 확인

        while (!que.isEmpty()) {
            Step step = que.poll();
//            System.out.println(step.cnt);
            if (step.cur == G) {
                ans = Math.min(ans, step.cnt);
                break;
            }

            if (step.cur < G) {
                if (!v[step.cur + U] && step.cur + U <= F) {
                    que.add(new Step(step.cur + U, step.cnt + 1));
                    v[step.cur + U] = true;
                } else {
                    if (!v[step.cur - D] && step.cur - D >= 1) {
                        que.add(new Step(step.cur - D, step.cnt + 1));
                        v[step.cur - D] = true;
                    }
                }
            } else {//목표보다 아래에 있으면
                if (!v[step.cur - D] && step.cur - D >= 1) {
                    que.add(new Step(step.cur - D, step.cnt + 1));
                    v[step.cur - D] = true;
                } else {
                    if (!v[step.cur + U] && step.cur + U <= F) {
                        que.add(new Step(step.cur + U, step.cnt + 1));
                        v[step.cur + U] = true;
                    }
                }
            }


        }
        if (ans == Integer.MAX_VALUE)
            System.out.println("use the stairs");
        else
            System.out.println(ans);
    }

}
