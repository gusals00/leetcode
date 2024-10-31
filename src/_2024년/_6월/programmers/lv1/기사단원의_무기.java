package _2024년._6월.programmers.lv1;

public class 기사단원의_무기 {
    public int solution(int number, int limit, int power) {
        int result = 0;
        for(int i=1; i<=number; i++) {
            int divisorCount = getDivisorCount(i);
            if(divisorCount <= limit) {
                result += divisorCount;
            } else {
                result += power;
            }
        }

        return result;
    }

    private int getDivisorCount(int num) {
        int count = 0;
        for(int i=1; i*i <= num; i++) {
            if(num % i == 0) {
                if(num/i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }

        return count;
    }
}
