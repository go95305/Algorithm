package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class CodeUp_최소대금 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pasta[] = new int[3];
        int juice[] = new int[2];
        for (int i = 0; i < 3; i++) {
            pasta[i] = sc.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            juice[i] = sc.nextInt();
        }
        Arrays.sort(pasta);
        Arrays.sort(juice);

        double sum = (pasta[0]+juice[0])*1.1;
        System.out.printf("%.1f",sum);
    }
}
