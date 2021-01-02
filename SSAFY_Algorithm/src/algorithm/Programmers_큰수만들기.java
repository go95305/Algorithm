package algorithm;


import java.util.Stack;

public class Programmers_큰수만들기 {
    public static void main(String[] args) {
        String number = "4177252841";
        char[] input = number.toCharArray();
        int k = 4;
        String answer = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            while (!st.isEmpty() && k > 0 && st.peek() < input[i]) {
                st.pop();
                k--;
            }
            st.push(input[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            if(k!=0){
                st.pop();
                k--;
            }else{
                sb.append(st.pop());
            }
        }
        answer = sb.reverse().toString();

        System.out.println(answer);
    }
}
