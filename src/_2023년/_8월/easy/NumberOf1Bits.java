package _2023년._8월.easy;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int cnt = 0;
        for(int i=0; i<32; i++) {
            if((n&1) == 1) {
                cnt++;
            }
            n >>= 1;
        }

        return cnt;
    }
}
