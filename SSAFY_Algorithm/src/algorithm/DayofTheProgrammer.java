package algorithm;
public class DayofTheProgrammer {
    public static void main(String[] args) {
        int year=1918;
        String setday = "";
        if (year >= 1700 && year <= 1917) {
            if (year % 4 == 0) {
                setday = "12.09";
            } else {
                setday = "13.09";
            }
        } else if (year == 1918) {
            setday="26.09";
        } else {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                setday = "12.09";
            } else {
                setday = "13.09";
            }
        }

        String answer = setday + "." + year;
//        return answer;
    }
}
