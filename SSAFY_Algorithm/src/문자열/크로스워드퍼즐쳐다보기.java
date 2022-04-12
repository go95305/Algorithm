package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 크로스워드퍼즐쳐다보기 {
    static class Word implements Comparable<Word> {
        String word;

        Word(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            return o.word.length() - this.word.length();
        }

        @Override
        public String toString() {
            return "Word{" +
                    "word='" + word + '\'' +
                    '}';
        }
    }

    static int R, C;
    static char map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#')
                    sb.append(map[i][j]);
                else {
//                    System.out.println(sb.toString());
                    if (sb.length() > 1) {
                        list.add(sb.toString());
                    }
                    sb = new StringBuilder();
                }
            }
            if (sb.length() > 1)
                list.add(sb.toString());
        }


        for (int i = 0; i < C; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < R; j++) {
                if (map[j][i] != '#')
                    sb.append(map[j][i]);
                else {
                    if (sb.length() > 1) {
                        list.add(sb.toString());
                    }
                    sb = new StringBuilder();
                }
            }
            if (sb.length() > 1)
                list.add(sb.toString());
        }

        Collections.sort(list);
        System.out.println(list.get(0));


    }
}
