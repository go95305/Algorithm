package algorithm;
import java.util.ArrayList;
import java.util.List;

public class BonAppetit {
    public static void main(String[] args) {
        int n = 4;
        int k = 1;
        List<Integer> bill = new ArrayList<>();
        bill.add(3);
        bill.add(10);
        bill.add(2);
        bill.add(9);
        int b = 7;
        int sum = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (i != k) {
                sum += bill.get(i);
            }
        }
        if ((sum / 2) == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println((sum / 2) > b ? (sum / 2) - b : b - (sum / 2));
        }
    }
}
