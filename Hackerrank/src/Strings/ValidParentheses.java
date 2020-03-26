package Strings;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        int len;
        do{
            len = s.length();
            s = s.replace("()","").replace("[]","").replace("{}","");
        }while(len != s.length());

        if(s.isEmpty()){
            return true;
        }

        return false;
    }

    public boolean isValidv2(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s==null || s.length() % 2 == 1)
            return false ;
        if(s.isEmpty())
            return true;
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();

    }
}
