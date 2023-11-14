package _2023년._11월.medium;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int pointer = 0;
        int secondPointer = numbers.length-1;
        int[] result = new int[2];

        while(pointer < secondPointer) {
            int sum = numbers[pointer] + numbers[secondPointer];
            if(sum == target) {
                result[0] = pointer+1;
                result[1] = secondPointer+1;
                break;
            } else if(sum < target) {
                pointer++;
            } else {
                secondPointer--;
            }
        }

        return result;
    }
}
