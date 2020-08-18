package algorithm;
public class BreakingTheRecords {
    public static void main(String[] args) {
        int n = 9;
        int[] scores = {10, 5, 20, 20, 4, 5, 2, 25, 1};
        int[] result = new int[2];
        int min = scores[0];
        int minCnt = 0;
        int max = scores[0];
        int maxCnt = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                maxCnt++;
            }
            if (scores[i] < min) {
                min = scores[i];
                minCnt++;
            }
        }
        result[0] = maxCnt;
        result[1] = minCnt;
//        return result;
    }
}
