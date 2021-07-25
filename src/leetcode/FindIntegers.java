package leetcode;

import java.util.Arrays;

public class FindIntegers {

    int isObey[];

    private int isObey(int num) {
        if (isObey[num] != -1)
            return isObey[num];

        int[] rep = new int[32];
        long i;
        int ind;
        int res = -1;
        for (ind=0, i = 1<<30 ; i>0; ind++, i=i/2) {
            rep[ind] = (num&i) == 0? 0:1;
            if (ind > 0 && rep[ind] == 1 && rep[ind-1] == 1) {
                res = 0;
                break;
            }
        }
        if (res == -1)
            res = 1;
        for (int j=num;j<isObey.length;j=j*2){
            isObey[j] = res;
        }
        return res;
    }

    public int findIntegers(int n) {
        isObey = new int[n+1];
        Arrays.fill(isObey, -1);
        isObey[0] = 1;
        int ans=0;
        for (int i = 0;i<=n;i++) {
            if ( isObey(i) == 0)
            System.out.printf("%d - %d\n", i, isObey(i));
            ans+=isObey(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindIntegers obj = new FindIntegers();
//        System.out.println(obj.findIntegers(4));
//        System.out.println(obj.findIntegers(1));
//        System.out.println(obj.findIntegers(2));
        System.out.println(obj.findIntegers(20));
    }
}
