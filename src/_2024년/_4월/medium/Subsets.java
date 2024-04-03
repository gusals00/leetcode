package _2024년._4월.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private void subsets(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        result.add(new ArrayList<>(list));

        for(int i=index; i<nums.length; i++) {
            list.add(nums[i]);
            subsets(result, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}
