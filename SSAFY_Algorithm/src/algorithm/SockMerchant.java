package algorithm;
import java.util.HashSet;
import java.util.Set;

public class SockMerchant {
    public static void main(String[] args) {
        int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int[] tmp = new int[100];
        Set<Integer> st = new HashSet<>();
        int pair = 0;
        for (int i = 0; i < ar.length; i++) {
            if (!st.contains(ar[i])) {
                int temp = ar[i];
                int sumtemp = 0;
                for (int j = 0; j < ar.length; j++) {
                    if (temp == ar[j]) {
                        sumtemp += temp;
                    }
                }
                sumtemp = sumtemp / temp;
                if (sumtemp > 1) {
                    pair += sumtemp / 2;
                }
                st.add(temp);
            }
        }
//        return pair;
    }
}
