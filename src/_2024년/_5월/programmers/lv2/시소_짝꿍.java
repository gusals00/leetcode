package _2024년._5월.programmers.lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소_짝꿍 {
    public long solution(int[] weights) {
        long result = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();

        for (int weight : weights) {
            double a = weight * 1.0;
            double b = (weight * 1.0) / 2.0;
            double c = (weight * 2.0) / 3.0;
            double d = (weight * 3.0) / 4.0;

            if(map.containsKey(a))
                result += map.get(a);
            if(map.containsKey(b))
                result += map.get(b);
            if(map.containsKey(c))
                result += map.get(c);
            if(map.containsKey(d))
                result += map.get(d);

            map.put(weight*1.0, map.getOrDefault(weight*1.0, 0) + 1);
        }

        return result;
    }
}
