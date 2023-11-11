package _2023년._11월.medium;

import java.util.*;

public class InsertDeleteGetRandomO1 {
    class RandomizedSet {

        List<Integer> list;
        Map<Integer, Integer> map;
        Random random;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if(map.containsKey(val))
                return false;

            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val))
                return false;

            int last = list.size() - 1;
            map.put(list.get(last), map.get(val));
            list.set(map.get(val), list.get(last));
            map.remove(val);
            list.remove(last);

            return true;
        }

        public int getRandom() {
            int r = random.nextInt(list.size());
            return list.get(r);
        }
    }
}
