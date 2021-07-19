package leetcode;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        for (int i=0;i<nums.length;i++) {
            if (i==0) {
                if (nums[i]>nums[i+1]) return i;
            }
            else if(i==nums.length-1) {
                if (nums[i]>nums[i-1]) return i;
            }
            else if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) return i;
        }
        return -1;
    }

    public int findPeakElementBinary(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r) {
            int mid = l + (r-l)/2;
            if(nums[mid]> nums[mid+1])
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }

    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();
        System.out.println(obj.findPeakElementBinary(new int[] {1,2,3,4,5,6,4}));
    }
}
