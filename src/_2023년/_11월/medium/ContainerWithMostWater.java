package _2023년._11월.medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int pointer = 0;
        int secondPointer = height.length-1;
        int maximumWater = 0;

        while(pointer < secondPointer) {
            int minHeight = Math.min(height[pointer], height[secondPointer]);
            maximumWater = Math.max(maximumWater, minHeight * (secondPointer-pointer));

            if(minHeight == height[pointer]) {
                pointer++;
            } else {
                secondPointer--;
            }
        }

        return maximumWater;
    }
}
