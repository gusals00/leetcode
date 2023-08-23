package _2023년._8월.medium;

public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        int result = 0;
        while(n > 0) {
            n/=5;
            result += n;
        }

        return result;
    }
}
