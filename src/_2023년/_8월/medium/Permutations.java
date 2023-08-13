package _2023년._8월.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        recur(nums, new ArrayList<>(), result);
        return result;
    }

    private void recur(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if(nums.length == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;

            list.add(nums[i]);
            visited[i] = true;
            recur(nums, list, result);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
