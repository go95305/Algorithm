package algorithm;
public class DivisibleSumPairs {
    public static void main(String[] args) {
        int n = 6;
        int k = 3;
        int[] ar = {1, 3, 2, 6, 1, 2};
        int t = 0;
        int cnt = 0;
        while (t < n - 1) {
            int sum = 0;
            for (int i = t + 1; i < n; i++) {
                sum = ar[t] + ar[i];
                if (sum % k == 0) {
                    cnt++;
                }
            }
            t++;
        }
//        return cnt;
    }
}
