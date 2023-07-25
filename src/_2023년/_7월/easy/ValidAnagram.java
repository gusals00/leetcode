package _2023년._7월.easy;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] arr = new int[26];

        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a'] += 1;
        }

        for(int i=0; i<s.length(); i++) {
            if(arr[t.charAt(i)-'a'] == 0)
                return false;
            else
                arr[t.charAt(i)-'a'] -= 1;
        }

        return true;
    }
}
