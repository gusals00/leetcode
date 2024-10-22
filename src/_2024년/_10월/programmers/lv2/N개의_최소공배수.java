package _2024년._10월.programmers.lv2;

public class N개의_최소공배수 {
    public int solution(int[] arr) {
        int lcm = getLCM(arr);

        return lcm;
    }

    private int getLCM(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        int gcd = getGCD(arr[0], arr[1]);
        int lcm = arr[0] * arr[1] / gcd;
        for(int i=2; i<arr.length; i++) {
            gcd = getGCD(lcm, arr[i]);
            lcm = lcm * arr[i] / gcd;
        }

        return lcm;
    }

    private int getGCD(int a, int b) {
        if(a % b == 0) {
            return b;
        }

        return getGCD(b, a%b);
    }
}
