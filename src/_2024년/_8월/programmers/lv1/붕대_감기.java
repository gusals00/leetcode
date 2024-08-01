package _2024년._8월.programmers.lv1;

public class 붕대_감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int success = 0;
        int maxHealth = health;
        int attackIndex = 0;

        for(int time = 1; time<=attacks[attacks.length-1][0]; time++) {
            if(time == attacks[attackIndex][0]) {
                health -= attacks[attackIndex][1];
                success = 0;

                if(health <= 0) {
                    return -1;
                }
                attackIndex++;
            } else {
                success++;
                health += bandage[1];

                if(success == bandage[0]) {
                    health += bandage[2];
                    success = 0;
                }
                if(health > maxHealth) {
                    health = maxHealth;
                }
            }
        }

        return health;
    }
}
