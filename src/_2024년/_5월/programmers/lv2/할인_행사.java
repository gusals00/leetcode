package _2024년._5월.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for(int i=0; i<=discount.length-10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for(int j=0; j<10; j++) {
                discountMap.put(discount[i+j], discountMap.getOrDefault(discount[i+j], 0) + 1);
            }

            if(canBuyAllProducts(wantMap, discountMap)) {
                result++;
            }
        }

        return result;
    }

    private boolean canBuyAllProducts(Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
        for(String key : wantMap.keySet()) {
            if(wantMap.get(key) != discountMap.get(key)) {
                return false;
            }
        }

        return true;
    }
}
