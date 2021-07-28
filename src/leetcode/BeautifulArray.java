package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/beautiful-array/discuss/186679/Odd-%2B-Even-Pattern-O(N)
public class BeautifulArray {
    public int[] beautifulArray(int N) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        while (arr.size()< N) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i : arr) {
                // generating odd numbers from 1,3,...arr[last]*2-1
                if (i*2 - 1 <=N)
                    temp.add(i*2 - 1);
            }
            for (int i : arr) {
                // generating odd numbers from 2,4,...arr[last]*2
                if (i*2 <=N)
                    temp.add(i*2);
            }
            arr = temp;
        }
        return arr.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        BeautifulArray obj = new BeautifulArray();
        System.out.println(Arrays.toString(obj.beautifulArray(1)));
        System.out.println(Arrays.toString(obj.beautifulArray(2)));
        System.out.println(Arrays.toString(obj.beautifulArray(3)));
        System.out.println(Arrays.toString(obj.beautifulArray(4)));
        System.out.println(Arrays.toString(obj.beautifulArray(5)));
        System.out.println(Arrays.toString(obj.beautifulArray(7)));
        System.out.println(Arrays.toString(obj.beautifulArray(8)));
        System.out.println(Arrays.toString(obj.beautifulArray(9)));
//        System.out.println(Arrays.toString(obj.beautifulArray(100)));
    }
}
