package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21921_블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int map[] = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            if (i == 0)
                map[i] = Integer.parseInt(st.nextToken());
            else
                map[i] = map[i - 1] + Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int duration = 0;
        for (int i = X - 1; i < map.length; i++) {
            if (i == X - 1) {
                ans = map[i];
                duration = 1;
            } else {
                if (ans < (map[i] - map[i - X])) {
                    ans = map[i] - map[i - X];
                    duration = 1;
                } else if (ans == (map[i] - map[i - X]))
                    duration++;
            }
        }


        if (ans == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(ans);
            System.out.println(duration);
        }

    }
}
