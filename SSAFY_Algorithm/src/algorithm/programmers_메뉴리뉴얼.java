package algorithm;

import java.util.*;
class 메뉴리뉴얼 {
    static HashMap<String, Integer> hm;
    static boolean v[];
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        List<String> list = new ArrayList<>();
        hm = new LinkedHashMap<>();
        for (int i = 0; i < orders.length; i++) {
            String tmp = orders[i];
            char charArray[] = tmp.toCharArray();
            Arrays.sort(charArray);
            orders[i] = String.valueOf(charArray);
        }

        for (int i = 0; i < orders.length; i++) {
            v = new boolean[orders[i].length()];
            powerset(orders[i].toCharArray(), 0, 0);

        }
        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            // compare로 값을 비교
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                // 내림 차순으로 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        List<String> maxkey;
        for (int i = 0; i < course.length; i++) {
            Set set = hm.keySet();
            Iterator iterator = set.iterator();
            int max = 0;
            maxkey = new ArrayList<>();
            int len = course[i];
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                if(hm.get(key)>1) {
                    if (key.length() == len) {
                        if (max < hm.get(key)) {
                            max = hm.get(key);
                            maxkey.removeAll(maxkey);
                            maxkey.add(key);
                        } else if (max == hm.get(key)) {
                            maxkey.add(key);
                        }
                    }
                }
            }
            for(int j=0;j<maxkey.size();j++){
                list.add(maxkey.get(j));
            }
        }
        Collections.sort(list);
        answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }


        return answer;
    }
    public void powerset(char[] order, int idx, int k) {
        if (idx == order.length) {
            if (k > 1) {
                String word = "";
                for (int i = 0; i < order.length; i++) {
                    if (v[i])
                        word += order[i];
                }
                hm.put(word, hm.getOrDefault(word, 0) + 1);
            }
            return;
        }

        v[idx] = true;
        powerset(order, idx + 1, k + 1);
        v[idx] = false;
        powerset(order, idx + 1, k);


    }
}