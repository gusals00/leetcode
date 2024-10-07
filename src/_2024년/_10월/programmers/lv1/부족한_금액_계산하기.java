package _2024년._10월.programmers.lv1;

public class 부족한_금액_계산하기 {
    public long solution(int price, int money, int count) {
        long result = 0;
        for(int i=1; i<=count; i++) {
            result += price*i;
        }

        if(money > result) {
            return 0;
        } else {
            return result - money;
        }
    }
}
