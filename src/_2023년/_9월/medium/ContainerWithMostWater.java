package _2023년._9월.medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;

        int result = 0;
        while(start < end) {
            if(height[start] < height[end]) {
                result = Math.max(result, height[start] * (end-start));
                start++;
            } else {
                result = Math.max(result, height[end] * (end-start));
                end--;
            }
        }

        return result;
    }
}
