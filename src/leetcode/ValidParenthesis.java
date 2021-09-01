package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        HashMap<Character, Character> par = new HashMap<>();
        par.put(')','(');
        par.put('}','{');
        par.put(']','[');
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if (par.containsKey(c)) {
                //closing bracket
                if(stack.isEmpty() || !stack.peek().equals(par.get(c))) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                //opening bracket
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis obj = new ValidParenthesis();
        System.out.println(obj.isValid("{}"));
        System.out.println(obj.isValid("{[()[{}]{}]}[]"));
        System.out.println(obj.isValid("{}["));
        System.out.println(obj.isValid("{)(}"));
        System.out.println(obj.isValid(""));
    }
}
