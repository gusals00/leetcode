package _2024년._4월.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int max = 0;
        int prev = -1;

        for(int i=0; i<s.length(); i++) {
            max = Math.max(max, map.get(s.charAt(i)));
            if(i == max) {
                result.add(max - prev);
                prev = max;
            }
        }

        return result;
    }
}
