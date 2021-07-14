package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B16637_괄호추가하기 {
    static int N, M;
    static List<Integer> math;
    static List<Character> operator;
    static boolean num[];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        math = new ArrayList<>();
        num = new boolean[N];
        char[] tmp = br.readLine().toCharArray();
        int idx = 0;
        for (int i = 0; i < N; i += 2)
            math.add(tmp[i] - '0');
        operator = new ArrayList<>();
        idx = 0;
        for (int i = 1; i < N; i += 2)
            operator.add(tmp[i]);
        ans = Integer.MIN_VALUE;
        dfs(math.get(0), 0);
        System.out.println(ans);

    }

    private static void dfs(Integer cur, int idx) {
        if (idx >= operator.size()) {
            ans = Math.max(ans, cur);
            return;
        }

        //처음부터 차근차근 괄호를 채워나간다.
        int value = operation(cur, math.get(idx + 1), operator.get(idx));
        dfs(value, idx + 1);

        if (idx + 1 < operator.size()) {
            value = operation(math.get(idx + 1), math.get(idx + 2), operator.get(idx + 1));
            dfs(operation(cur, value, operator.get(idx)), idx + 2);
        }

    }

    private static int operation(Integer num1, Integer num2, Character oper) {
        if (oper == '+') {
            return num1 + num2;
        } else if (oper == '*') {
            return num1 * num2;
        } else {
            return num1 - num2;
        }
    }
}
/*
1. dfs를 통해 순차적으로 괄호안의 값을 구하고 그 값을 다음 값으로 dfs에 보내자
2.
3. 새로운 순열에서 1번부터 반복

 */