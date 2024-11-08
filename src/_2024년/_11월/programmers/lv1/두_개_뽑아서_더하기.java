package _2024년._11월.programmers.lv1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] result = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);

        return result;
    }
}
