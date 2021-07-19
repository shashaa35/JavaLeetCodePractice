package leetcode;

import java.util.Arrays;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int [] arr1 = new int[256];
        int [] arr2 = new int[256];
        for (char c: s.toCharArray()) {
            arr1[c] = arr1[c]+1;
        }
        for (char c: t.toCharArray()) {
            arr2[c] = arr2[c]+1;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        IsomorphicStrings obj = new IsomorphicStrings();
        System.out.println(obj.isIsomorphic("aassddrrrewwwsssaaaa","aassddrrrewwwsssaaaa"));
    }
}
