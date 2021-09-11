package leetcode;

public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {

        for(int i= shifts.length-2;i>=0;i--)
            shifts[i] = (shifts[i+1] % 26 + shifts[i] % 26) % 26;
        char[] ans = s.toCharArray();
        for(int i=0;i<ans.length;i++) {
            ans[i] = shift(ans[i], (shifts[i] % 26));
        }
        return new String(ans);
    }

    char shift(char c, int val) {
        //a=>0 , b=>1, ... z=>25
        int cInt = c - 'a';
        int cShiftedInt = (cInt + val)%26;
        return (char) ('a' + cShiftedInt);
    }

    public static void main(String[] args) {
        ShiftingLetters obj = new ShiftingLetters();
        System.out.println(obj.shiftingLetters("abc", new int[] {3,5,9}));
        System.out.println(obj.shiftingLetters("aaa", new int[] {1,1,1}));
        System.out.println(obj.shiftingLetters("ruu", new int[] {26,9,17}));
//        System.out.println((char) ('u'+));
    }
}
