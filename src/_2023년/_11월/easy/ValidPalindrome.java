package _2023년._11월.easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;

        while(start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if(!Character.isLetterOrDigit(startChar)) {
                start++;
            } else if(!Character.isLetterOrDigit(endChar)) {
                end--;
            } else if(Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) {
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }
}
