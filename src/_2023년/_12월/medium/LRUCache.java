package _2023년._12월.medium;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);

        if(map.size() > capacity) {
            map.remove(map.keySet().iterator().next());
        }
    }
}

