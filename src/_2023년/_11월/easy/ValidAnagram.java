package _2023년._11월.easy;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if(s.length() != t.length()) return false;

        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++) {
            if(--count[t.charAt(i)-'a'] < 0)
                return false;
        }

        return true;
    }
}
