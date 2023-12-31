package _2023년._9월.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];

            while(i+1 < nums.length && nums[i]+1 == nums[i+1])
                i++;

            if(num == nums[i]) {
                result.add(String.valueOf(num));
            } else {
                result.add(num + "->" + nums[i]);
            }
        }

        return result;
    }
 }
