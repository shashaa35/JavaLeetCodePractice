package leetcode;

import java.util.Arrays;

//https://youtu.be/a9-NtLIs1Kk Tushar roy , why this is fibonacci
//Solution : https://youtu.be/4OL7WdGKC1Y
//https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/solution/
public class FindIntegers {

    public int findIntegers(int n) {
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i=2;i<f.length;i++)
            f[i] = f[i-1] + f[i-2];
        int i=30, ans = 0, prev_bit =0;
        while (i>=0) {
            if ((n & (1<<i)) != 0) {
                //this binary index is one
                ans+=f[i];
                if (prev_bit == 1) {
                    ans--;
                    break;
                }
                prev_bit = 1;
            } else {
                prev_bit = 0;
            }
            i--;
        }
        return ans+1;
    }

    public static void main(String[] args) {
        FindIntegers obj = new FindIntegers();
//        System.out.println(obj.findIntegers(4));
//        System.out.println(obj.findIntegers(1));
//        System.out.println(obj.findIntegers(2));
        System.out.println(obj.findIntegers(8));
    }
}
