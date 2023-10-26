package _2023년._10월.medium;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        while(n >= 5) {
            n/=5;
            result += n;
        }

        return result;
    }
}
