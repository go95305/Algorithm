package algorithm;
public class CircularArrayRotation {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int k = 2;

        int[] queries = {0,1,2};
        int[] answer = new int[queries.length];
        int [] tmp=new int[a.length];

        if(k>a.length){
            k=k%a.length;
        }
        int cnt=0;
        for (int j = a.length - k; j < a.length; j++) {
            tmp[cnt]=a[j];
            cnt++;
        }
        for (int j = 0; j < a.length - k; j++) {
            tmp[cnt]=a[j];
            cnt++;
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i]=tmp[queries[i]];
        }
//        return answer;

    }
}
