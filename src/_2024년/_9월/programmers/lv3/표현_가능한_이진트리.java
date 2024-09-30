package _2024년._9월.programmers.lv3;

public class 표현_가능한_이진트리 {
    public int[] solution(long[] numbers) {
        int[] result = new int[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            String binaryString = Long.toBinaryString(numbers[i]);
            binaryString = getFullTree(binaryString);

            if(check(binaryString)) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    private boolean check(String binary) {
        int length = binary.length();
        if(length == 1) {
            return true;
        }

        char c = binary.charAt(length / 2);
        String left = binary.substring(0, length / 2);
        String right = binary.substring(length / 2 + 1);
        boolean leftValid = check(left);
        boolean rightValid = check(right);

        if((c == '0' && left.contains("1")) || (c == '0' && right.contains("1"))) {
            return false;
        }

        return leftValid && rightValid;
    }

    private String getFullTree(String binaryString) {
        int count = 1;
        int length = 0;
        while(length < binaryString.length()) {
            length += count;
            count *= 2;
        }

        int zeroCount = length - binaryString.length();
        return "0".repeat(zeroCount) + binaryString;
    }
}
