package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1068_트리 {
    static ArrayList<Integer> list[];
    static int ans;
    static boolean v[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        ans = 0;
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        int start = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp != -1)
                list[tmp].add(i);
            else
                start = i;
        }

        v = new boolean[N];
        int deleteNode = Integer.parseInt(br.readLine());
        v[deleteNode] = true;
        if (deleteNode != start)
            searchNode(start, deleteNode);
        System.out.println(ans);
    }

    private static void searchNode(int idx, int delete) {
        v[idx] = true;
        int size = list[idx].size();
        if (size == 0) {
            ans++;
            return;
        }
        for (int i = 0; i < size; i++) {
            if (!v[list[idx].get(i)])
                searchNode(list[idx].get(i), delete);
            else{
                if(size==1){
                    ans++;
                }
            }
        }
    }
}
