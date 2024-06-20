package _2024년._6월.programmers.lv2;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int result = 0;
        int index = 0;
        Arrays.sort(people);

        for(int i=people.length-1; i>=index; i--) {
            if(people[index] + people[i] <= limit) {
                index++;
            }
            result++;
        }

        return result;
    }
}
