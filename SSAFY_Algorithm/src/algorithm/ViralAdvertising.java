package algorithm;
public class ViralAdvertising {
    public static void main(String[] args) {
        int n=3;
        int k=5;
        int cumulative=0;
        for(int i=0;i<n;i++){
            cumulative+=k/2;
            k=(k/2)*3;
        }
//        return cumulative;
    }
}
//나누기 2, *3을 해서 다시 시작
