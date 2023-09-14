package _2023년._9월.easy;

import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<magazine.length(); i++) {
            char c = magazine.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        for(int i=0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer orDefault = map.getOrDefault(c, 0);

            if(orDefault == 0)
                return false;
            else {
                map.put(c, orDefault-1);
            }
        }

        return true;
    }
}
