package leetcode;

public class MinFlipsMonoIncr {
    public int minFlipsMonoIncr(String s) {
        int lengthOfString = s.length();
        int[] prefixSumArr = new int[lengthOfString+1];
        for (int i=1;i<=lengthOfString;i++) {
            prefixSumArr[i] = prefixSumArr[i-1] + (s.charAt(i-1) == '1' ? 1:0);
        }
        int ans = Integer.MAX_VALUE;
        for (int i=0;i<=lengthOfString;i++){
            int numberOfOnesInFirstHalf = prefixSumArr[i];
            int numberOfOnesInSecondHalf = prefixSumArr[lengthOfString] - numberOfOnesInFirstHalf;
            int numberOfDigitsInSecondHalf = lengthOfString - i;
            int numberOfOnesNeedsToBeFlipped = numberOfOnesInFirstHalf;
            int numberOfZeroesNeedsToBeFlipped = numberOfDigitsInSecondHalf - numberOfOnesInSecondHalf;
            int numberOfDigitsNeededToBeFlipped = numberOfOnesNeedsToBeFlipped + numberOfZeroesNeedsToBeFlipped;
            ans = Math.min(ans, numberOfDigitsNeededToBeFlipped);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinFlipsMonoIncr obj = new MinFlipsMonoIncr();
        System.out.println(obj.minFlipsMonoIncr("0011")==0);
        System.out.println(obj.minFlipsMonoIncr("0111")==0);
        System.out.println(obj.minFlipsMonoIncr("1011")==1);
        System.out.println(obj.minFlipsMonoIncr("1100")==2);
        System.out.println(obj.minFlipsMonoIncr("1111")==0);
        System.out.println(obj.minFlipsMonoIncr("000000")==0);
        System.out.println(obj.minFlipsMonoIncr("")==0);
    }
}
