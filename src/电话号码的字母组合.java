import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class 电话号码的字母组合 {
    public static void main(String[] args){
        Solution24 s = new Solution24();
        s.letterCombinations("234");
    }
}

class Solution24 {
    ArrayList a = new ArrayList();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return a;
        }
        get("", digits);
        return a;

    }

    private String getString(String a) {
        HashMap h = new HashMap();
        h.put("2", "abc");
        h.put("3", "def");
        h.put("4", "ghi");
        h.put("5", "jkl");
        h.put("6", "mno");
        h.put("7", "pqrs");
        h.put("8", "tuv");
        h.put("9", "wxyz");
        return (String) h.get(a);
    }

    private void get(String res, String s) {
        if (s.length() == 0) {
            a.add(res);
        } else {
            String str = getString(s.substring(0, 1));
            for (int i = 0; i < str.length(); i++) {
                String letter = str.substring(i,i+1);
                get(res+letter, s.substring(1));
            }
        }
    }
}