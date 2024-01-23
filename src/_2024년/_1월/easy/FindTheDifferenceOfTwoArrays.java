package _2024년._1월.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        for (int num : set) {
            if(!set2.contains(num)) {
                result.get(0).add(num);
            }
        }
        for (int num : set2) {
            if(!set.contains(num)) {
                result.get(1).add(num);
            }
        }

        return result;
    }
}
