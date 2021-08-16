package leetcode;

import java.util.Arrays;

public class RangeSumQueryImmutable {
    class NumArray {
        int [] prefixSumArr;
        public NumArray(int[] nums) {
            prefixSumArr = new int[nums.length+1];
            prefixSumArr[0] = 0;
            for (int i=1; i<=prefixSumArr.length; i++) {
                prefixSumArr[i] = prefixSumArr[i-1] + nums[i];
            }
//            System.out.println(Arrays.toString(prefixSumArr));
        }

        public int sumRange(int left, int right) {
            return prefixSumArr[right] - prefixSumArr[left];
        }
    }
}
