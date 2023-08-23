package _2023년._8월.medium;

public class PowXN {
    public double myPow(double x, int n) {
        long nn = n;
        double result = recur(x, Math.abs(nn));

        if(n < 0) {
            result = 1 / result;
        }

        return result;
    }

    private double recur(double x, long n) {
        if(n == 0)
            return 1;

        if(n % 2 == 0) {
            return recur(x * x, n/2);
        } else {
            return x * recur(x * x, (n-1)/2);
        }
    }
}
