package leetcode;

//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (diff > Math.abs(sum - target)) {
                        ans = sum;
                        diff = Math.abs(sum - target);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSumClosest obj = new ThreeSumClosest();
        System.out.println(obj.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(obj.threeSumClosest(new int[]{-1, 2, 1, -4}, -100));
    }

}
