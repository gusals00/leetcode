package _2023년._8월.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        recur(candidates, target, 0, new ArrayList<>(), result, 0);
        return result;
    }

    private void recur(int[] nums, int target, int sum, List<Integer> list, List<List<Integer>> result, int start) {
        if(sum == target) {
            result.add(new ArrayList<>(list));
            return;
        } else if(sum > target) {
            return;
        }

        for(int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            recur(nums, target, sum+nums[i], list, result, i);
            list.remove(list.size()-1);
        }
    }
}
