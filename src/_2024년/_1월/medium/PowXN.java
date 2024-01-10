package _2024년._1월.medium;

public class PowXN {
    public double myPow(double x, int n) {
        double result = recur(x, n);

        return n > 0 ? result : 1 / result;
    }

    private double recur(double x, int n) {
        if(n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            return recur(x * x, n / 2);
        } else {
            return x * recur(x * x, n / 2);
        }
    }
}
