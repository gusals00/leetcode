package _2024년._9월.programmers.lv1;

public class 콜라_문제 {
    public int solution(int a, int b, int n) {
        int result = 0;
        while(n >= a) {
            int cola = n / a * b;
            result += cola;
            n = n%a + cola;
        }

        return result;
    }
}
