package _2024년._1월.medium;

public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        while(left < right) {
            right = right & right-1;
        }

        return right;
    }
}
