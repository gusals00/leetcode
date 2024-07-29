package _2024년._7월.programmers.lv2;

public class 다음_큰_숫자 {
    public int solution(int n) {
        int bitCount = Integer.bitCount(n++);

        while(Integer.bitCount(n) != bitCount) {
            n++;
        }

        return n;
    }
}
