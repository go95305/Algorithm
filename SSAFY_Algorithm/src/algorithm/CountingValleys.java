package algorithm;

public class CountingValleys {
    public CountingValleys() {
    }

    public static void main(String[] args) {
        String s = "DDUUDDUDUUUD";
        int seaLevel = 0;
        int moving = 0;
        boolean flag = true;
        int valley = 0;
        int prevmov = 0;

        for(int i = 0; i < s.length(); ++i) {
            prevmov = moving;
            if (s.charAt(i) == 'D') {
                --moving;
                if (seaLevel > moving) {
                    flag = true;
                }
            } else {
                ++moving;
                if (seaLevel <= moving) {
                    flag = false;
                }
            }

            if (!flag && prevmov < 0) {
                ++valley;
            }
        }

        System.out.println(valley);
    }
}
