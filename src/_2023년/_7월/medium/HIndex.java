package _2023년._7월.medium;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {
    public int hIndex(int[] citations) {
        Integer[] integers = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, Collections.reverseOrder());

        for(int i=0; i<integers.length; i++) {
            if(i+1 > integers[i]) {
                return i;
            }
        }

        return integers.length;
    }
}
