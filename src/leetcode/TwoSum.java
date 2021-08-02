package leetcode;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(target-nums[i]))
                return new int[]{i,m.get(target-nums[i])};
            m.put(nums[i],i);
        }
        return new int[0];
    }
}
