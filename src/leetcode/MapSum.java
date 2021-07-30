package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/map-sum-pairs/
public class MapSum {

    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        Set<String> set = map.keySet();
        for (String s : set) {
            sum += s.startsWith(prefix)? map.get(s): 0;
        }
        return sum;
    }


}
