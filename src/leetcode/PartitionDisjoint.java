package leetcode;

import com.sun.tools.javac.util.Assert;

//https://leetcode.com/problems/partition-array-into-disjoint-intervals/
public class PartitionDisjoint {
    public int partitionDisjoint(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        for (int i=1 ;i<nums.length;i++){
            left[i] = Math.max(left[i-1], nums[i]);
        }
        right[nums.length-1] = nums[nums.length-1];
        for (int i=nums.length-2;i>=0;i--) {
            right[i] = Math.min(right[i+1], nums[i]);
        }

        for (int i=1;i<nums.length;i++) {
            if(left[i-1] <= right[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        PartitionDisjoint obj = new PartitionDisjoint();
//        System.out.println(obj.partitionDisjoint(new int[] {5,0,3,8,6}));
//        System.out.println(obj.partitionDisjoint(new int[] {1,1,1,0,6,12}));
        Assert.check(obj.partitionDisjoint(new int[] {5,0,3,8,6})==3);
        Assert.check(obj.partitionDisjoint(new int[] {1,1,1,0,6,12})==4);
    }
}
