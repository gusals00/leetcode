package _2023년._7월.medium;

import java.util.*;

public class InsertDeleteGetRandom {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int last = list.get(list.size() - 1);

        list.set(index, last);

        map.put(last, index);
        map.remove(val);
        list.remove(list.size()-1);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
