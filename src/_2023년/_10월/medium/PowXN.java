package _2023년._10월.medium;

public class PowXN {
    public double myPow(double x, int n) {
        double result = recur(x, n);

        if(n < 0) {
            return 1 / result;
        } else
            return result;
    }

    private double recur(double x, int n) {
        if(n == 0)
            return 1;

        if (n % 2 == 0) {
            return recur(x * x, n / 2);
        } else {
            return x * recur(x * x, n / 2);
        }
    }
}
