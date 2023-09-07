package _2023년._9월.medium;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 1;

        for(int i=citations.length-1; i>=0 && citations[i] >= result; i--) {
            result++;
        }

        return result-1;
    }
}
