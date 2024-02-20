package _2024년._2월.easy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        for(int i = 0; i < length; i++) {
            if(flowerbed[i] == 0) {
                int prev = i == 0 ? 0 : flowerbed[i-1];
                int next = i == length-1 ? 0 : flowerbed[i+1];

                if(prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return n <= 0;
    }
}
