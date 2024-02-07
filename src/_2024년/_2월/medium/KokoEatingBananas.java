package _2024년._2월.medium;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 1;
        int end = piles[piles.length-1];

        while(start <= end) {
            int mid = (start + end) / 2;
            if(canEat(piles, mid, h)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private boolean canEat(int[] piles, int mid, int h) {
        int hour = 0;
        for (int pile : piles) {
            hour += Math.ceil((double)pile/mid);
        }

        return hour <= h;
    }
}
