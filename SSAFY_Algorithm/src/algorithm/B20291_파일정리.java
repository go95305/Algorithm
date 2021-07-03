package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class B20291_파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] word = br.readLine().split("\\.");
            hm.put(word[1], hm.getOrDefault(word[1], 0) + 1);
        }

        TreeMap<String, Integer> tm = new TreeMap<>(hm);
        for (String key: tm.keySet()){
            System.out.println(key+" "+tm.get(key));
        }
    }
}
