package _2023년._8월.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, 1, n, k, new ArrayList<>());
        return result;
    }

    private void backtracking(List<List<Integer>> result, int num, int n, int k, List<Integer> list) {
        if(list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=num;  i<=n; i++) {
            list.add(i);
            backtracking(result, i+1, n, k, list);
            list.remove(list.size()-1);
        }
    }
}
