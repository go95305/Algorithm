package algorithm;
public class AngreyProfessor {
    public static void main(String[] args) {
        int k = 2;
        int[] a = {0,-1,2,1};
        int cnt = 0;
        String answer="";
        for(int i=0;i<a.length;i++){
            if(a[i]<=0){
                cnt++;
            }
        }
        if(cnt<k){
            answer="YES";
        }
        else{
            answer="NO";
        }
//        return answer;
    }
}
