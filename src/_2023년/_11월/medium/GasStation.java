package _2023년._11월.medium;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int check = 0;
        int result = 0;

        for(int i=0; i<gas.length; i++) {
            sum += gas[i]-cost[i];
            check += gas[i]-cost[i];

            if(check < 0) {
                result = i+1;
                check = 0;
            }
        }

        if(sum < 0)
            return -1;
        else
            return result;
    }
}
