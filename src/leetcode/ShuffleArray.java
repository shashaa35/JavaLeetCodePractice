package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class ShuffleArray {
    int [] arr;
    Random r;

    public ShuffleArray(int[] nums) {
        arr = nums;
        r = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return arr;
    }


    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int [] ans = new int[arr.length];
//        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        boolean[] vis = new boolean[arr.length];
        for (int i=0;i<ans.length;i++){
//            ans[i] = list.remove(r.nextInt(list.size()));
            int index;
            do {
                index = r.nextInt(arr.length);
            } while (vis[index]);
            ans[i] = arr[index];
            vis[index] = true;
        }
        return ans;
    }

    public static void main(String[] args) {
        ShuffleArray obj = new ShuffleArray(new int[] {1,2,3,45,6,6,7,5,4,5,3,5,3,3});
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
    }
}
