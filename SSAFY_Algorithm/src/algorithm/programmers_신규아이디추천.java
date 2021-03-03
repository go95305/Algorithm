package algorithm;
import java.util.*;
class 신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        for(int i=0;i<new_id.length();i++){
            char tmp = new_id.charAt(i);
            if(!(tmp=='-') && !(tmp=='_') && !(tmp=='.') && !(tmp>=48 && tmp<=57) &&!(tmp>=97 && tmp<=122)){
                new_id = new_id.replace(Character.toString(tmp),"=");
            }
        }

        new_id=new_id.replace("=","");
        System.out.println(new_id);
        Stack<Character> st = new Stack<>();


        String nStr="";

        int cnt=0;
        for(int i=0;i<new_id.length();i++){
            char tmp = new_id.charAt(i);
            if(tmp=='.')
                cnt++;
            else
                cnt=0;


            if(cnt>=2)
                continue;


            st.push(tmp);
        }
        if(!st.isEmpty()&&st.peek()=='.')
            st.pop();
        if(!st.isEmpty()&&st.get(0)=='.')
            st.remove(0);

        if(st.isEmpty())
            st.push('a');

        if(st.size()>=16){
            int len =st.size()-15;
            for(int i=0;i<len;i++)
                st.pop();

            if(!st.isEmpty()&&st.peek()=='.')
                st.pop();

        }

        if(st.size()<=2){
            char tmp = st.peek();
            int len = 3-st.size();
            for(int i=0;i<len;i++)
                st.push(tmp);
        }


        while(!st.isEmpty())
            nStr=Character.toString(st.pop())+nStr;




        System.out.println(nStr);
        answer = nStr;
        return answer;
    }
}