import java.util.HashMap;

public class P205_同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sTot = new HashMap<>();
        HashMap<Character, Character> tTos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char m = s.charAt(i);
            char n = t.charAt(i);
            if ((sTot.containsKey(m) && sTot.get(m) != n) || (tTos.containsKey(n) && tTos.get(n) != m)) {
                return false;
            }
            sTot.put(m, n);
            tTos.put(n, m);

        }
        return true;
    }
}
