package Strings;

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
}
