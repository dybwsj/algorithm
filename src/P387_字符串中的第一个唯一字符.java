import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author: duyubo
 * @date: 2020年12月23日, 0023 09:17
 * @description:
 */
public class P387_字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
