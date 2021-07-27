package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int ans = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int sum;
            int low = i+1, high = nums.length-1;
            while(low<high) {
                sum =  nums[i]+ nums[low] + nums[high];
                if (diff > Math.abs(sum - target)) {
                    ans = sum;
                    diff = Math.abs(sum - target);
                }
                if (sum > target) {
                    //we need to decrease the sum
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSumClosest obj = new ThreeSumClosest();
        System.out.println(obj.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(obj.threeSumClosest(new int[]{1,2,5,10,11}, 12));
        System.out.println(obj.threeSumClosest(new int[]{-1, 2, 1, -4}, -100));
    }

}
