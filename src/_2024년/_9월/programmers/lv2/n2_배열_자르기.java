package _2024년._9월.programmers.lv2;

public class n2_배열_자르기 {
    public int[] solution(int n, long left, long right) {
        int resultLength = Long.valueOf(right - left + 1).intValue();
        int[] result = new int[resultLength];
        int index = 0;

        for(long i=left; i<=right; i++) {
            long col = i/n;
            long row = i%n;

            result[index++] = Math.max((int)col,(int)row) + 1;
        }

        return result;
    }
}
