package leetcode;

//https://leetcode.com/problems/trapping-rain-water
//prefix sum DP solution
//Time: O(n), Space: O(n)
public class TrappingRainWater {
    public int trap(int[] height) {
        int ans = 0, leftMax = 0, rightMax = 0, left = 0, right = height.length-1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax < height[left])
                    leftMax = height[left];
                ans+= leftMax - height[left];
                left++;
            } else {
                if (rightMax < height[right])
                    rightMax = height[right];
                ans+= rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        System.out.println(obj.trap(new int[]{1,2,3,0,5}));
    }
}
