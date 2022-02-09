package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B19583_싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S, E, Q;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken().replace(":", ""));
        E = Integer.parseInt(st.nextToken().replace(":", ""));
        Q = Integer.parseInt(st.nextToken().replace(":", ""));



        HashMap<String, Integer> hm = new HashMap<>();
        int cnt = 0;
        String word = "";
        while ((word = br.readLine()) != null) {
            String tmp[] = word.split(" ");
            int time = Integer.parseInt(tmp[0].replace(":", ""));
            String name = tmp[1];
            if (time <= S) {
                hm.put(name, 1);
            } else if (time >= E && time <= Q) {
                if (hm.containsKey(name) && hm.get(name) == 1) {
                    cnt++;
                    hm.put(name,0);
                }
            }
        }


        System.out.println(cnt);
    }
}
