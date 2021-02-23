public class P567_字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        int[] arr = new int[26];
        for (int i = 0; i < length; i++) {
            --arr[s1.charAt(i) - 'a'];
        }
        int length2 = s2.length();
        int left = 0;
        int right = 0;
        for (; right < length2; right++) {
            ++arr[s2.charAt(right) - 'a'];
            while (arr[s2.charAt(right) - 'a'] > 0) {
                --arr[s2.charAt(left) - 'a'];
                left++;
            }
            if (right - left + 1 == length) {
                return true;
            }
        }
        return false;
    }
}
