package _2024년._7월.programmers.lv2;

public class 숫자의_표현 {
    public int solution(int n) {
        int result = 0;

        for(int i=1; i<=n; i++) {
            int sum = 0;

            for(int j=i; j<=n; j++) {
                sum += j;

                if(sum >= n) {
                    if(sum == n) {
                        result++;
                    }
                    break;
                }
            }
        }

        return result;
    }
}
