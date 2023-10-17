package _2023년._10월.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, 0, result, new ArrayList<>());

        return result;
    }

    private void combinationSum(int[] candidates, int target, int sum, int index, List<List<Integer>> result, List<Integer> list) {
        if(sum > target) {
            return;
        }
        if(sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<candidates.length; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, target, sum+candidates[i], i, result, list);
            list.remove(list.size()-1);
        }
    }
}
