package algorithm;
public class UtopinTree {
    public static void main(String[] args) {
        int n = 0;
        int height = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                height *= 2;
            } else {
                height += 1;
            }
        }
    }
}

//2 cycles of growth every year. Each spring, it doubles in height.
// Each summer, its height increases by 1 meter.
//여름에 1meter 되고 봄에 2배가 된다.