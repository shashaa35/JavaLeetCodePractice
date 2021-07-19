package leetcode;

import java.util.Arrays;

public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++) {
            for (int j=i+1;j<nums.length-1;j++) {
                for (int k=j+1;k<nums.length;k++) {
                    if (nums[i] + nums[j] > nums[k])
                        result++;
                    else
                        break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TriangleNumber obj = new TriangleNumber();
        System.out.println(obj.triangleNumber(new int[] {4,2,3,4}));
        System.out.println(obj.triangleNumber(new int[] {2,2,3,4}));
    }
}
