package _2024년._2월.medium;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];

        Arrays.sort(potions);
        for(int i=0; i<spells.length; i++) {
            int start = 0;
            int end = potions.length-1;
            while(start <= end) {
                int mid = (start + end) / 2;
                if((long) spells[i] * potions[mid] >= success) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            result[i] = potions.length - start;
        }

        return result;
    }
}
