package _2024년._1월.medium;

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
