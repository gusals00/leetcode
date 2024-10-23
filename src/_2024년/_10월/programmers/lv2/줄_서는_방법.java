package _2024년._10월.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 줄_서는_방법 {
    public int[] solution(int n, long k) {
        int[] result = new int[n];
        List<Integer> list = new ArrayList<>();

        long factorial = 1;
        for(int i=1; i<=n; i++) {
            list.add(i);
            factorial *= i;
        }

        k--;
        int index = 0;
        while(index < n) {
            factorial /= n - index;
            result[index++] = list.remove((int) (k / factorial));
            k %= factorial;
        }

        return result;
    }
}
