package leetcode;

//https://leetcode.com/problems/trapping-rain-water
//prefix sum DP solution
//Time: O(n), Space: O(n)
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        int[] rightMax = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for (int i = height.length-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        int sum=0;
        for(int i=0;i<height.length;i++) {
            sum+= Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        System.out.println(obj.trap(new int[]{1,2,3,0,5}));
    }
}
