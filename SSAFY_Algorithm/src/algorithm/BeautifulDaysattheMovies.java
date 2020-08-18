package algorithm;
public class BeautifulDaysattheMovies {
    public static void main(String[] args) {
        int i = 20;
        int j = 23;
        int k = 6;
        int cnt=0;
        for (int s = i; s<= j; s++) {
            String newNum="";
            String []tmp=Integer.toString(s).split("");
            for(int e=tmp.length-1;e>=0;e--) {
                newNum += tmp[e];
            }
            if(((Integer.parseInt(newNum)-s)%k==0)){
                cnt++;
            }
        }
//        return cnt;

    }
}
