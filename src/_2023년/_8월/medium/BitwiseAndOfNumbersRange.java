package _2023년._8월.medium;

public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        while(right > left) {
            right = right & right-1;
        }

        return right&left;
    }
}
