package leetcode;

import java.util.Arrays;

public class CustomSortString {
    public String customSortString(String order, String str) {
        int arr[] = new int[255];
        Arrays.fill(arr, 0);
        for (int i=0;i<str.length();i++){
            arr[str.charAt(i)]++;
        }
        StringBuilder result = new StringBuilder();
        for (int i=0;i<order.length();i++) {
            while (arr[order.charAt(i)]>0) {
               result.append(order.charAt(i));
               arr[order.charAt(i)]--;
            }
        }
        for (int i='a';i<='z';i++) {
            while (arr[i]>0) {
                result.append((char) i);
                arr[i]--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        CustomSortString obj = new CustomSortString();
        System.out.println(obj.customSortString("cba", "abcd"));
        System.out.println(obj.customSortString("cba", "absdfsadfasdfcabsdfsdcfcabcsfsd"));
    }
}
