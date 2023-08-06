package _2023년._8월.easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        long reverse = 0;
        long tmp = x;

        while(tmp != 0) {
            int digit = (int) (tmp%10);
            reverse = reverse * 10 + digit;
            tmp /= 10;
        }
        return reverse == x;
    }
}
