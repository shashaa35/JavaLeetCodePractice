package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> e: result) {
            ans.add(e);
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSum obj = new FourSum();
        System.out.println(obj.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(obj.fourSum(new int[]{2, 2, 2, 2}, 8));
        System.out.println(obj.fourSum(new int[]{-5,5,4,-3,0,0,4,-2}, 4));
    }
}
