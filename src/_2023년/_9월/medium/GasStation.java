package _2023년._9월.medium;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int check = 0;
        int total = 0;
        int result = 0;

        for(int i=0; i<gas.length; i++) {
            check += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if(check < 0) {
                check = 0;
                result = i+1;
            }
        }

        if(total < 0)
            return -1;
        return result;
    }
}
