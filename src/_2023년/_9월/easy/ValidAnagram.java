package _2023년._9월.easy;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        if(s.length() != t.length())
            return false;

        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }

        for(int i=0; i<t.length(); i++) {
            if(arr[t.charAt(i)-'a']-- < 1)
                return false;
        }

        return true;
    }
}
