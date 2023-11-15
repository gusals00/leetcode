package _2023년._11월.medium;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String string = String.valueOf(chars);
            if(!map.containsKey(string)) {
                map.put(string, new ArrayList<>());
            }

            map.get(string).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
