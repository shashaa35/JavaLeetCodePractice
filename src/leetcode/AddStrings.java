package leetcode;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        int carry = 0;
        int firstPointer = num1.length();
        int secondPointer = num2.length();
        StringBuilder sb = new StringBuilder();
        while (firstPointer > 0 || secondPointer > 0) {
            firstPointer--;
            secondPointer--;
            int d1 = firstPointer>=0? num1.charAt(firstPointer)-'0':0;
            int d2 = secondPointer>=0? num2.charAt(secondPointer)-'0':0;
            int res = d1+d2+carry;
            carry = res/10;
            res = res%10;
            sb.append(res);
        }
        if (carry>0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings obj = new AddStrings();
        System.out.println(obj.addStrings("123", "234"));
        System.out.println(obj.addStrings("129", "234"));
        System.out.println(obj.addStrings("1", "234"));
        System.out.println(obj.addStrings("0", "234"));
        System.out.println(obj.addStrings("1231231242314123", "1"));
        System.out.println(obj.addStrings("90999", "1"));
    }
}
