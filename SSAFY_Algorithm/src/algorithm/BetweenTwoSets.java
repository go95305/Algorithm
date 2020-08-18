package algorithm;
import java.util.ArrayList;
import java.util.List;

public class BetweenTwoSets {
    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(4);
        List<Integer> b = new ArrayList<>();
        b.add(16);
        b.add(32);
        b.add(96);
        int cnta = 0;
        int cntb = 0;
        int answer = 0;
        int x = a.get(a.size() - 1);
        for (; x <= b.get(0); x++) {
            for (int i = 0; i < a.size(); i++) {
                if (x % a.get(i) == 0) {
                    cnta++;
                }
            }
            if (cnta == a.size()) {
                for (int j = 0; j < b.size(); j++) {
                    if (b.get(j) % x == 0) {
                        cntb++;
                    }
                }
                if (cntb == b.size()) {
                    answer++;
                }
            }
            cnta = 0;
            cntb = 0;
        }
//        return answeer;
    }
}
