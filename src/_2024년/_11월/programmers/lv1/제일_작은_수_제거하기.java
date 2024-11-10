package _2024년._11월.programmers.lv1;

public class 제일_작은_수_제거하기 {
    public int[] solution(int[] arr) {
        if(arr.length == 1) {
            return new int[]{-1};
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        int[] result = new int[arr.length-1];
        int index = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == min) {
                continue;
            }

            result[index++] = arr[i];
        }

        return result;
    }
}
