package algorithm;
public class ElectronicsShop {
    public static void main(String[] args) {
        int[] keyboards = {3, 1};
        int[] drives = {5, 2, 8};
        int b = 10;
        int maxSum = -1;

        for (int i = 0; i < keyboards.length; i++) {
            int temp = keyboards[i];
            for (int j = 0; j < drives.length; j++) {
                if (temp + drives[j] <= b) {
                    if (maxSum < temp + drives[j]) {
                        maxSum = temp + drives[j];
                    }
                }
            }
        }
        if (maxSum == -1) {
            System.out.println(-1);
        } else {
            System.out.println(maxSum);
        }
    }
}
