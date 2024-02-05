package _2024년._2월.easy;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int start =1;
        int end =n;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(guess(mid) == 0) {
                return mid;
            } else if(guess(mid) > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    private int guess(int n) {
        return 0;
    }
}
