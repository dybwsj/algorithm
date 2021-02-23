import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class 有效的括号 {
    public static void main(String[] args){
        System.out.println(new Solution11().isValid("[[]]"));
    }
}

class Solution11 {
    public boolean isValid(String s) {
        if(s.length() == 0){
            return false;
        }
        HashMap h = new HashMap();
        h.put(')','(');
        h.put('}','{');
        h.put(']','[');
        Stack m = new Stack();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '['){
                m.push(s.charAt(i));
            } else if(!m.isEmpty()){
                char c = (char) m.pop();
                if(c != (char)h.get(s.charAt(i))){
                    return false;
                }
            } else {
                return false;
            }
        }
        if(m.isEmpty()){
            return true;
        }
        return false;
    }
}