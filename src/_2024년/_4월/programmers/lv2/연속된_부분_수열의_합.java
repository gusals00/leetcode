package _2024년._4월.programmers.lv2;

public class 연속된_부분_수열의_합 {
    public int[] solution(int[] sequence, int k) {
        int[] result = {0, sequence.length-1};
        int end = 0;
        int sum = 0;

        for(int start = 0; start < sequence.length; start++) {
            while(end < sequence.length && sum < k) {
                sum += sequence[end++];
            }

            if(sum == k && (end-start-1 < result[1]-result[0])) {
                result[0] = start;
                result[1] = end-1;
            }

            sum -= sequence[start];
        }

        return result;
    }
}
