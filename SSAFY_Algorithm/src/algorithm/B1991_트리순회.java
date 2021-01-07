package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1991_트리순회 {
    static boolean v[];
    static StringBuilder fsb;
    static StringBuilder msb;
    static StringBuilder bsb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Character> list[] = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        v = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char from = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            list[from - 'A'].add(left);
            list[from - 'A'].add(right);
        }
        fsb = new StringBuilder();
        frontree('A', list);
        System.out.println(fsb);
        msb = new StringBuilder();
        middletree('A', list);
        System.out.println(msb);
        bsb = new StringBuilder();
        backtree('A', list);
        System.out.println(bsb);

    }

    private static void backtree(char alphabet, ArrayList<Character>[] list) {
        int size = list[alphabet - 'A'].size();
//        if (size == 0) {
//            return;
//        }
        for (int i = 0; i < size; i++) {
            if (list[alphabet - 'A'].get(i) != '.') {
                backtree(list[alphabet - 'A'].get(i), list);
            }
        }
        bsb.append(alphabet);
    }

    private static void middletree(char alphabet, ArrayList<Character>[] list) {
        int size = list[alphabet - 'A'].size();
        char left, right;
        if (size == 2) {
            left = list[alphabet - 'A'].get(0);
            right = list[alphabet - 'A'].get(1);
            if (left != '.')
                middletree(list[alphabet - 'A'].get(0), list);
            msb.append(alphabet);
            if (right != '.')
                middletree(list[alphabet - 'A'].get(1), list);

        } else if (size == 1) {
            if (list[alphabet - 'A'].get(0) != '.')
                middletree(list[alphabet - 'A'].get(0), list);
            msb.append(alphabet);
        } else {
            msb.append(alphabet);
        }
    }

    private static void frontree(char alphabet, ArrayList<Character> list[]) {
        //전위순회
        fsb.append(alphabet);
        int size = list[alphabet - 'A'].size();
        for (int i = 0; i < size; i++) {
            if (list[alphabet - 'A'].get(i) != '.')
                frontree(list[alphabet - 'A'].get(i), list);
        }
    }
}
