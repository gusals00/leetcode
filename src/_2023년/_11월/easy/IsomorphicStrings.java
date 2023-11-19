package _2023년._11월.easy;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] left = new int[128];
        int[] right = new int[128];

        for(int i=0; i<s.length(); i++) {
            int leftChar = s.charAt(i);
            int rightChar = t.charAt(i);

            if(left[leftChar] != right[rightChar]) return false;

            left[leftChar] = i+1;
            right[rightChar] = i+1;
        }

        return true;
    }
}
