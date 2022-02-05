package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B13022_늑대와올바른단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alph = new int[4];
        boolean isW = false;
        char beforeAlph = 'z';
        int ans = 1;
        //wwwoolllfff
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp == 'w') {
                if (beforeAlph == 'z' || beforeAlph == 'f' || beforeAlph == 'w') {
                    if (isW) {//이어서 w를 받는 상황
                        alph[0]++;
                    } else {//처음 혹은 f 이후로 w를 받는상황
                        //wolf의 갯수가 맞는지 확인
                        if (beforeAlph == 'f') {
                            if (!isCntValid(alph)) {
                                ans = 0;
                                break;
                            }
                        }
                        alph = new int[4];
                        alph[0]++;
                        isW = true;
                    }
                    beforeAlph = tmp;
                } else {
                    ans = 0;
                    break;
                }

            } else if (tmp == 'o') {
                if (beforeAlph == 'w' || beforeAlph == 'o') {
                    beforeAlph = 'o';
                    alph[1]++;
                } else {
                    ans = 0;
                    break;
                }
            } else if (tmp == 'l') {
                if (beforeAlph == 'o' || beforeAlph == 'l') {
                    beforeAlph = 'l';
                    alph[2]++;
                } else {
                    ans = 0;
                    break;
                }
            } else if (tmp == 'f') {
                if (beforeAlph == 'l' || beforeAlph == 'f') {
                    isW = false;
                    beforeAlph = 'f';
                    alph[3]++;
                } else {
                    ans = 0;
                    break;
                }
            }
        }
        if (!isCntValid(alph))
            ans = 0;

        System.out.println(ans);
    }

    private static boolean isCntValid(int[] alph) {
        int w = alph[0];
        int o = alph[1];
        int l = alph[2];
        int f = alph[3];
        if (w == o && o == l && l == f)
            return true;
        return false;
    }
}
//wwolfolf