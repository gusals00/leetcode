package _2023년._12월.easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int compare = x;
        int reverse = 0;
        while(x != 0) {
            reverse = reverse*10 + x%10;
            x /= 10;
        }

        return compare == reverse;
    }
}
