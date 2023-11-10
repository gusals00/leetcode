package _2023년._11월.medium;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > count) {
                count++;
            }
        }

        return count;
    }
}
