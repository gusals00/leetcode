package _2023년._7월.easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String string = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        if(s.length() == 0) return true;

        StringBuilder sb = new StringBuilder();

        for(int i=string.length()-1; i>=0;i--) {
            sb.append(string.charAt(i));
        }

        return string.equals(sb.toString());
    }
}
