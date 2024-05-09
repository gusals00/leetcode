package _2024년._5월.programmers.lv2;

public class 점_찍기 {
    public long solution(int k, int d) {
        long result = 0;

        for(int i=0; i<=d; i+=k) {
            int y = (int) Math.sqrt((long) d*d - (long) i*i);
            result += y/k + 1;
        }

        return result;
    }
}
