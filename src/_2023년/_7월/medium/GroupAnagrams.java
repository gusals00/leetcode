package _2023년._7월.medium;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);

            if(!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }

            map.get(s).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
