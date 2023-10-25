package _2023년._10월.medium;

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        while(right > left) {
            right = right & right-1;
        }

        return right;
    }
}
