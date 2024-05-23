package _2024년._5월.programmers.lv2;

import java.util.*;

public class 주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> recordMap = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();

        for (String record : records) {
            String[] strings = record.split(" ");
            String[] time = strings[0].split(":");
            int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            String carNumber = strings[1];

            if(strings[2].equals("IN")) {
                recordMap.put(carNumber, minute);
            } else {
                int diff = minute - recordMap.remove(carNumber);
                timeMap.put(carNumber, timeMap.getOrDefault(carNumber, 0) + diff);
            }
        }

        int lastMinute = 23 * 60 + 59;
        for (String key : recordMap.keySet()) {
            timeMap.put(key, timeMap.getOrDefault(key, 0) + lastMinute - recordMap.get(key));
        }

        ArrayList<String> carNumbers = new ArrayList<>(timeMap.keySet());
        Collections.sort(carNumbers);

        int[] result = new int[carNumbers.size()];
        for(int i=0; i<result.length; i++) {
            String carNumber = carNumbers.get(i);
            int minute = timeMap.get(carNumber);

            if(minute > fees[0]) {
                result[i] = fees[1] + (int)Math.ceil((double)(minute-fees[0])/fees[2]) * fees[3];
            } else {
                result[i] = fees[1];
            }
        }

        return result;
    }
}
