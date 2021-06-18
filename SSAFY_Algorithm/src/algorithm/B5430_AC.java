package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class B5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String ans = "";
            char p[] = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            String num = br.readLine();
            num = num.replace("[", "");
            num = num.replace("]", "");
            num = num.replace(",", " ");
            String[] number = num.split(" ");
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(number[i]));
            }

            boolean reverseIdx = false;
            //명령 수행
            for (int i = 0; i < p.length; i++) {
                if (p[i] == 'D') {
                    if (list.size() == 0) {
                        ans = "error";
                        break;
                    } else {
                        if (!reverseIdx)
                            list.remove(0);
                        else
                            list.remove(list.size() - 1);
                    }

                } else {
                    reverseIdx = !reverseIdx;
                }
//                System.out.println(list);
            }
            if (ans.equals("error"))
                System.out.println(ans);
            else {
                print(list, reverseIdx);
            }
        }

    }

    private static void print(List<Integer> list, boolean reverseIdx) {
        System.out.print("[");
        if (reverseIdx) {
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i));
                if (i != 0)
                    System.out.print(",");
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i != list.size() - 1)
                    System.out.print(",");
            }
        }
        System.out.println("]");

    }
}
