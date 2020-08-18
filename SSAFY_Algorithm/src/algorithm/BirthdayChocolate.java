package algorithm;
import java.util.ArrayList;
import java.util.List;

public class BirthdayChocolate {
    public static void main(String[] args) {
        int n = 5;
        List<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(2);
        int d = 3;
        int m = 2;
        int cnt = 0;
        int sum = 0;
        if (m == s.size()) {//한번에 읽어들이는 요소의 개수와 리스트 요소의 갯수가 같으면
            for (int i = 0; i < s.size(); i++) {
                sum += s.get(i);
            }
            if (sum == d) {
                cnt++;
            }
        } else {//한번에 읽어들이는 요소의 개수와 리스트 요소의 갯수가 다르면
            for (int i = 0; i <= s.size() - m; i++) {
                for (int j = i; j < m + i; j++) {
                    sum += s.get(j);
                }
                if (sum == d) {
                    cnt++;
                }
                sum = 0;
            }
        }
//        return cnt;
    }
}
