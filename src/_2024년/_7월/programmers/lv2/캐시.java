package _2024년._7월.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return 5 * cities.length;
        }

        int result = 0;
        List<String> list = new ArrayList<>();
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();

            if(list.contains(city)) {
                result += 1;
                list.remove(city);
                list.add(city);
            } else {
                result += 5;
                list.add(city);

                if(list.size() > cacheSize) {
                    list.remove(0);
                }
            }
        }

        return result;
    }
}
