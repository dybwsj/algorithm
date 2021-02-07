/**
 * @author: duyubo
 * @date: 2021年02月02日, 0002 09:23
 * @description: 滑动窗口
 */
public class P424_替换后的最长重复字符 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int window = 0;
        int[] charNum = new int[26];
        while (right < len) {
            int win = ++charNum[s.charAt(right) - 'A'];
            // 窗口内最大重复字符个数
            window = Math.max(window, win);
            // 窗口内非重复字符的个数
            if (right - left - window + 1 > k) {
                charNum[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
