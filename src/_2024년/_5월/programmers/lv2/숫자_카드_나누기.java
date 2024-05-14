package _2024년._5월.programmers.lv2;

public class 숫자_카드_나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int result = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for(int i=1; i<arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        if(!isDivided(arrayB, gcdA)) {
            result = Math.max(result, gcdA);
        }
        if(!isDivided(arrayA, gcdB)) {
            result = Math.max(result, gcdB);
        }

        return result;
    }

    private boolean isDivided(int[] array, int gcd) {
        for (int i : array) {
            if(i % gcd == 0) {
                return true;
            }
        }

        return false;
    }

    private int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }
}
