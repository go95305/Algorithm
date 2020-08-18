package algorithm;
public class CatsAndMouse {
    public static void main(String[] args) {
        int x = 1;
        int y = 3;
        int z = 2;
        String answer = "";
        if (Math.abs(z - x) > Math.abs(z - y)) {//Cat b가 더 가까운 경우
            answer = "Cat B";
        } else if (Math.abs(z - x) < Math.abs(z - y)) {
            answer = "Cat A";
        }else{
            answer = "Mouse C";
        }
        System.out.println(answer);
    }
}
