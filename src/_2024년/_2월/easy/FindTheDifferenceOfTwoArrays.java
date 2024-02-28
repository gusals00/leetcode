package _2024년._2월.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        for (int i : set) {
            if(!set2.contains(i)) {
                result.get(0).add(i);
            }
        }
        for (int i : set2) {
            if(!set.contains(i)) {
                result.get(1).add(i);
            }
        }

        return result;
    }
}
