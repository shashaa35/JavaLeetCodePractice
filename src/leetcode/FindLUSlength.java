package leetcode;

//https://leetcode.com/problems/longest-uncommon-subsequence-ii/
public class FindLUSlength {
    boolean isValidSubsequence(String a, String b) {
        //if length of a is greater than b, then we need to check for subsequence
        //as we are interested in longest subsequence which will a and cant be found in b as it has more chars.
        if (a.length() > b.length()) return false;


        int i=0,j=0;
        while (i<a.length() && j<b.length()) {
            if (a.charAt(i)==b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }

    public int findLUSlength(String[] strs) {
        int ans = -1;
        for (int i=0;i<strs.length;i++) {
            boolean isUncommon = true;
            for (int j=0;j<strs.length;j++) {
                if (i!=j && isValidSubsequence(strs[i], strs[j])) {
                    isUncommon = false;
                    break;
                }
            }
            if (isUncommon) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindLUSlength obj = new FindLUSlength();
        System.out.println(obj.findLUSlength(new String[]{"abcd", "fed", "rty", "abcd"}));
        System.out.println(obj.findLUSlength(new String[]{"abcd", "fed", "rty", "abcd"}));
        System.out.println(obj.findLUSlength(new String[]{"aaa", "aaa", "aa", "a"}));
    }
}
