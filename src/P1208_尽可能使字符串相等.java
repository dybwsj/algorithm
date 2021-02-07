/**
 * @author: duyubo
 * @date: 2021年02月05日, 0005 09:09
 * @description: 滑动窗口
 */
public class P1208_尽可能使字符串相等 {
    public static void main(String[] args) {
        P1208_尽可能使字符串相等 s = new P1208_尽可能使字符串相等();
        s.equalSubstring("abcd", "bcdf", 3);
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int window = 0;
        int right = 0;
        int len = s.length();
        char [] sch  = s.toCharArray();
        char [] tch = t.toCharArray();
        int [] result = new int[len];
        for(int i = 0; i < len; i++) {
            result[i] = Math.abs(sch[i] - tch[i]);
        }
        for (; right < len; right++) {
            window += result[right];
            if (window > maxCost) {
                window -= result[left];
                left++;
            }
        }
        return right - left;
    }
}
