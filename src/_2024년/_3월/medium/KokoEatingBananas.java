package _2024년._3월.medium;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int start = 1;
        int end = piles[piles.length-1];
        while(start <= end) {
            int speed = (start + end) / 2;

            if(canEatAll(piles, speed, h)) {
                end = speed - 1;
            } else {
                start = speed + 1;
            }
        }

        return start;
    }

    private boolean canEatAll(int[] piles, int speed, int h) {
        int hour = 0;
        for(int i=0; i<piles.length; i++) {
            hour += Math.ceil((double) piles[i]/speed);
        }

        return hour <= h;
    }
}
