package project190;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValidParen(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing bracket
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false; // Closing bracket does not match the top of the stack
                }
            } else {
                return false; // Invalid character
            }
        }

        return stack.isEmpty(); // All opening brackets must be matched
    }

    public static void main(String[] args) {
        String parentheses = "{[([]])]}";
        boolean validP = isValidParen(parentheses);
        System.out.println("Are the parentheses valid? " + validP);
    }
}
