package _2024년._3월.medium;

import java.util.TreeSet;

public class SmallestInfiniteSet {

    private TreeSet<Integer> set;
    private int smallest;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        smallest = 1;
    }

    public int popSmallest() {
        if(set.isEmpty()) {
            return smallest++;
        }

        return set.pollFirst();
    }

    public void addBack(int num) {
        if(smallest > num) {
            set.add(num);
        }
    }
}
