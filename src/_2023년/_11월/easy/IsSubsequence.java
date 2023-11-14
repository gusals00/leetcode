package _2023년._11월.easy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int tLength = t.length();
        int sIndex = 0;
        if(s.length() == 0)
            return true;

        for(int i=0; i<tLength; i++) {
            if(t.charAt(i) == s.charAt(sIndex)) {
                sIndex++;
            }

            if(sIndex == s.length())
                return true;
        }

        return false;
    }
}
