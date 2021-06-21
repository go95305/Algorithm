package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B16719_ZOAC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();

        char[] newWord = new char[word.length];
        Arrays.fill(newWord, '/');
        boolean v[] = new boolean[word.length];
        int idx = 0;
        int num = 0;
        while (num < word.length) {
            if (num == 0) {
                //처음은 그냥 알파벳순으로 하나 뽑는다.(문자와 인덱스)
                idx = first(word);
                v[idx] = true;
                newWord[idx] = word[idx];
            } else {
                String compare = "";
                int selIdx = 0;
                for (int i = 0; i < word.length; i++) { // 사용가능한 기존 문자열을하나씩 붙여보여 사전순중 맨앞을 선택(문자, 인덱스)
                    if (!v[i]) {
                        char[] copy = newWord.clone();
                        String tmpCopy = testWord(i, word, copy); // 하나씩 붙여본다.
                        //사전순 앞의 문자열을 구한다.
                        if (compare.equals("")) {
                            compare = tmpCopy;
                            selIdx=i;
                        }
                        else {
                            if (!compareWord(compare, tmpCopy)) {
                                compare = tmpCopy;
                                selIdx = i;
                            }
                        }
                    }
                }
                //사전순 앞서는 문자의 인덱스를 찾았으면 새로운 문자열에 더해준다. 방문체크해주고
                v[selIdx] = true;
                newWord[selIdx] = word[selIdx];
            }

            for (int i=0;i<v.length;i++){
                if (v[i]){
                    System.out.print(newWord[i]);
                }
            }
            System.out.println();
            num++;
        }

    }

    private static boolean compareWord(String compare, String tmpCopy) {
        if (compare.length() == tmpCopy.length()) {// 같은 경우 compareto비교
            if (compare.compareTo(tmpCopy) > 0) {//compare가 앞서면
                return false;
            } else {
                return true;
            }
        } else {// 길이가 다를경우 긴게 무조건 앞선다.
            if (compare.length() < tmpCopy.length())
                return false;
            else
                return true;
        }
    }

    private static String testWord(int idx, char[] word, char[] copy) {
        copy[idx] = word[idx];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != '/')
                sb.append(copy[i]);
        }
        return sb.toString();
    }

    private static int first(char[] word) {
        int fastIdx = 0;
        char tmp = word[0];
        for (int i = 1; i < word.length; i++) {
            if (tmp > word[i]) {
                fastIdx = i;
                tmp = word[i];
            }
        }

        return fastIdx;
    }
}
