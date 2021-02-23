import java.util.Stack;

public class 最长的有效括号 {
    public static void main(String[] args){
        Solution23 s = new Solution23();
        System.out.println(s.longestValidParentheses("()(()"));
    }
}

class Solution23 {
    public int longestValidParentheses(String s) {
        if (s.length() == 0){
            return 0;
        }
        int len = 0;
        int max = 0;
        Stack<Integer> m = new Stack();
        m.push(-1);
        while (s.charAt(len) == ')'){
            len++;
        }
        for (int i = len; i < s.length(); i++){
            if (s.charAt(i) == '('){
                m.push(i);
            } else{
                m.pop();
                if (m.isEmpty()){
                    m.push(i);
                } else {
                    max = Math.max(max, i - m.peek());
                }
            }
        }
        return max;

    }
}
