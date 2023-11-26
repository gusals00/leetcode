package _2023년._11월.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getCombination(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void getCombination(int[] candidates, int target, int sum, int index, List<Integer> list, List<List<Integer>> result) {
        if(sum > target)
            return;
        if(sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<candidates.length; i++) {
            list.add(candidates[i]);
            getCombination(candidates, target, sum+candidates[i], i, list, result);
            list.remove(list.size()-1);
        }
    }
}
