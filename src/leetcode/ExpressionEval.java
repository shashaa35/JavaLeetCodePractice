package leetcode;

import java.util.Stack;

public class ExpressionEval {
    public int calculate(String s) {
        int sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0 ; i< s.length();i++) {
            if(Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                    i++;
                    sum = sum*10 + s.charAt(i) - '0';
                }
                result = result + sign * sum;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                int prevSign = stack.pop();
                int prevVal = stack.pop();
                result = prevVal + prevSign * result;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        ExpressionEval obj = new ExpressionEval();
        System.out.println(obj.calculate("- (3 + (4 + 5))"));
        System.out.println(obj.calculate("1 + 1"));
        System.out.println(obj.calculate(" 2-1 + 2 "));
        System.out.println(obj.calculate(" (1+(4+5+2)-3)+(6+8)"));
        System.out.println(obj.calculate("-3"));
        System.out.println(obj.calculate(""));
        System.out.println(obj.calculate("1"));
    }
}

