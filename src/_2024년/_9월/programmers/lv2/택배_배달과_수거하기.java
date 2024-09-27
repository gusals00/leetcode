package _2024년._9월.programmers.lv2;

public class 택배_배달과_수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long result = 0;
        int delivery = 0;
        int pickup = 0;

        for(int i=deliveries.length-1; i>=0; i--) {
            delivery += deliveries[i];
            pickup += pickups[i];

            while(delivery > 0 || pickup > 0) {
                delivery -= cap;
                pickup -= cap;
                result += (i+1)*2;
            }
        }

        return result;
    }
}
