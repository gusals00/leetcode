package _2024년._2월.easy;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int max = 0;
        for (int i : gain) {
            altitude += i;
            max = Math.max(altitude, max);
        }

        return max;
    }
}
