package _2024년._3월.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(new ArrayList<>(), result, 1, 0, k, n);

        return result;
    }

    private void dfs(List<Integer> list, List<List<Integer>> result, int index, int sum, int k, int n) {
        if(list.size() == k) {
            if(sum == n) {
                result.add(new ArrayList<>(list));
            }

            return;
        }

        for(int i=index; i<=9; i++) {
            list.add(i);
            dfs(list, result, i+1, sum+i, k, n);
            list.remove(list.size()-1);
        }
    }
}
