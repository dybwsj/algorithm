import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class P389_找不同 {
    public static void main(String[] args) {
        System.out.println(findTheDifference("aa", "aaa"));
    }
    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> hp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hp.put(s.charAt(i), hp.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i < t.length(); i++) {
            if (hp.containsKey(t.charAt(i))) {
                hp.put(t.charAt(i), hp.get(t.charAt(i)) - 1);
            }
            if (hp.getOrDefault(t.charAt(i), -1) < 0) {
                return t.charAt(i);
            }
        }
        /**
         * 通过异或找出不同的那个字母
         */
//        char res = 0;
//        for(char i : s.toCharArray()) {
//            res ^= i;
//        }
//        for(char j : t.toCharArray()) {
//            res ^= j;
//        }
//        return res;
        return ' ';
    }
}
