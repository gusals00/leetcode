package _2024년._2월.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 0, 1, k, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int sum, int index, int k, int n) {
        if(list.size() > k) {
            return;
        }
        if(list.size() == k && sum == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i<=9; i++) {
            list.add(i);
            dfs(result, list, sum+i, i+1, k, n);
            list.remove(list.size()-1);
        }
    }
}
