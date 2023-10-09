package _2023년._10월.easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        int reverse = 0;
        int temp = x;

        while(temp != 0) {
            reverse = reverse*10 + temp%10;
            temp /= 10;
        }

        return x == reverse;
    }
}
