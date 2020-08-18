package algorithm;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {
    public static void main(String[] args) {
        int n = 6;
        Integer[] num = {1, 2, 2, 3, 1, 2};
        List<Integer> a= Arrays.asList(num);
        Collections.sort(a);//리스트를 오름차순으로 정렬
        int max = 0;//maxLen과 비교하여 더 크면 갱신
        int maxLen = 0;//조건에 맞는 수의 개수
        for (int i = 0; i < a.size(); i++) {
            int temp = a.get(i);//기준값 설정
            for (int j = i; j < a.size(); j++) {
                if (a.get(j) - temp <= 1) {//기준값이랑 차이가 1과 같거나 작으면
                    max++;//기준에 맞는 수의 개수 증가
                } else {
                    break;
                }
            }
            if (max > maxLen) {
                maxLen = max;//기준에 맞는 수의 최장 길이를 구한다.
            }
            max = 0;
        }
        System.out.println(maxLen);
    }
}
