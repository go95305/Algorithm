package algorithm;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B9934_완전이진트리 {
    static int arr[];
    static int N;
    static List<Integer> list[];
    static boolean v[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        int size = (int) (Math.pow(2, N) - 1);
        arr = new int[size];
        int start = size / 2;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        search(0, size - 1, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                System.out.print(list[i].get(j) + " ");
            }
            System.out.println();
        }

    }

    private static void search(int s, int e, int depth) {
        if (depth == N)
            return;

        int m = (s + e) / 2;
        list[depth].add(arr[m]);

        search(s, m - 1, depth + 1);
        search(m + 1, e, depth + 1);
    }


}
