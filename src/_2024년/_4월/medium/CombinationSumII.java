package _2024년._4월.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, 0, result, new ArrayList<>());

        return result;
    }

    private void combinationSum(int[] candidates, int target, int sum, int index, List<List<Integer>> result, List<Integer> list) {
        if(sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if(sum > target) {
            return;
        }

        for(int i=index; i<candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1])
                continue;
            list.add(candidates[i]);
            combinationSum(candidates, target, sum+candidates[i], i+1, result, list);
            list.remove(list.size()-1);
        }
    }
}
