package leetcode;

//https://leetcode.com/problems/decode-ways/
//https://www.youtube.com/watch?v=YcJTyrG3bZs
//
public class DecodeWays {
    Integer[] memo;
    public int numDecodings(String s) {
        memo = new Integer[s.length()];
        return numDecodings(s, 0);
    }

    private int numDecodings(String s, int index) {
        if (index == s.length())
            return 1;

        if (s.charAt(index) == '0')
            return 0;

        if (memo[index] != null)
            return memo[index];

        int ways1 = numDecodings(s, index + 1);
        int ways2 = 0;
        if (index + 2 <= s.length()) {
            int nextNumber = Integer.parseInt(s.substring(index, index + 2));
            if (nextNumber <= 26)
                ways2 = numDecodings(s, index + 2);
        }
        memo[index] = ways1 + ways2;
        return ways1 + ways2;
    }

    public static void main(String[] args) {
        DecodeWays obj = new DecodeWays();
        System.out.println(obj.numDecodings("2263"));
        System.out.println(obj.numDecodings("2"));
        System.out.println(obj.numDecodings("22"));
        System.out.println(obj.numDecodings("10"));
    }
}
