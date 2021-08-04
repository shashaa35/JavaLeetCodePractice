package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/discuss/1380366/Java-or-Python-or-Recursion-Visualization
public class Subsets2 {
    List<List<Integer>> output;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort( nums );
        output = new ArrayList();
        backTracking( 0, nums, new ArrayList() );
        return output;
    }

    public void backTracking( int start, int[] nums, List<Integer> list )
    {
        output.add( new ArrayList(list) );
        for( int i = start;i < nums.length; i++ )
        {
            if( i != start && nums[i] == nums[i-1] )
                continue;
            list.add( nums[i]);
            backTracking(i+1,nums,list);
            list.remove( list.size()-1);
        }
    }
}
