package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> duplicate = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String tmp = st.nextToken();
            set.add(tmp);
        }

        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            String tmp = st.nextToken();
            if (set.contains(tmp))
                duplicate.add(tmp);
        }

        Collections.sort(duplicate);

        System.out.println(duplicate.size());
        for (int i=0;i<duplicate.size();i++){
            System.out.println(duplicate.get(i));
        }
    }
}
