package algorithm;

public class Programmers_점프와순간이동 {
    public static void main(String[] args) {
        int n=5;
        int ans = 0;
        while(n!=0){
            if(n%2==0){
                n/=2;
            }else{
                n-=1;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
