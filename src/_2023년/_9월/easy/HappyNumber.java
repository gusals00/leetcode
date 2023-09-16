package _2023년._9월.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(n != 1) {
            int sum = 0;
            while(n > 0) {
                sum = sum + (n % 10) * (n % 10);
                n/=10;
            }

            if(!set.add(sum))
                return false;

            n = sum;
        }

        return true;
    }
}
