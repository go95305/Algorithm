package algorithm;
public class DrawingBook {
    public DrawingBook() {
    }

    public static void main(String[] args) {
        int n = 6;
        int p = 2;
        int turn = 0;
        int i;
        if (n - p > p - 1) {
            for(i = 1; i < p; ++turn) {
                i += 2;
            }
        } else if (n % 2 == 0) {
            for(i = n; i > p; ++turn) {
                i -= 2;
            }
        } else {
            for(i = n; i > p + 1; ++turn) {
                i -= 2;
            }
        }

    }
}
