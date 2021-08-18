package leetcode;

//https://leetcode.com/problems/decode-ways/
//https://youtu.be/cQX3yHS0cLo
//Iterative DP
public class DecodeWays {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i =2;i<=s.length();i++){
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if (oneDigit >= 1)
                dp[i] += dp[i-1];
            if (twoDigit >=10 && twoDigit<=26)
                dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays obj = new DecodeWays();
        System.out.println(obj.numDecodings("2263"));
        System.out.println(obj.numDecodings("2"));
        System.out.println(obj.numDecodings("22"));
        System.out.println(obj.numDecodings("10"));
    }
}
