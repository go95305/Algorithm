package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1969_DNA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] dna = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            dna[i] = st.nextToken();
        }


        StringBuilder sb = new StringBuilder();
        int alpha[] = new int[26];
        for (int i = 0; i < M; i++) {
            alpha = new int[26];
            for (int j = 0; j < N; j++) {
                alpha[dna[j].charAt(i) - 'A']++;
            }
            int index = mostAlpha(alpha);
            sb.append((char) (index + 'A'));
        }

        //hamming distance 구하기
        int hammingDist = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (dna[j].charAt(i) != sb.toString().charAt(i))
                    hammingDist++;
            }
        }
        System.out.println(sb.toString());
        System.out.println(hammingDist);


    }

    private static int mostAlpha(int[] alpha) {
        int idx = 0;
        int max = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] > max) {
                max = alpha[i];
                idx = i;
            }
        }
        return idx;
    }
}
