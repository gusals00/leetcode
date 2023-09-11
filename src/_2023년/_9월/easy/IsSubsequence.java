package _2023년._9월.easy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int sLength = s.length();
        for(int i=0; i<t.length() && sLength>sIndex; i++) {
            if(t.charAt(i) == s.charAt(sIndex))
                sIndex++;
        }

        if(sIndex == s.length())
            return true;
        else
            return false;
    }
}
