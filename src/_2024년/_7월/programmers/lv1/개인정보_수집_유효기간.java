package _2024년._7월.programmers.lv1;

import java.util.*;

public class 개인정보_수집_유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : terms) {
            String[] term = s.split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }

        int[] todayDate = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();

        for (int i=0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int[] date = Arrays.stream(privacy[0].split("\\.")).mapToInt(Integer::parseInt).toArray();

            int availableMonth = 0;
            availableMonth += (todayDate[0] - date[0]) * 12;
            availableMonth += todayDate[1] - date[1];
            if(todayDate[2] < date[2]) {
                availableMonth -= 1;
            }

            if(map.get(privacy[1]) <= availableMonth) {
                result.add(i+1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
