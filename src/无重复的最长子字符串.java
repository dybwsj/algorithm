import java.util.HashMap;

public class 无重复的最长子字符串 {
    public static void main(String[] args){
        Solution2 s = new Solution2();
        int result = s.lengthOfLongestSubstring("abba");
        System.out.println(result);
    }
}

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int start=0,end=0;
        HashMap hashmap = new HashMap();
        int result = end - start;
        for(int i = 0; i < s.length();i++){
            if(hashmap.containsKey(s.charAt(i))) {
                //防止出现abba这样的回文字符串
                start = (int) hashmap.get(s.charAt(i)) > start ? (int) hashmap.get(s.charAt(i)): start;
            }
            hashmap.put(s.charAt(i),i+1);
            end+=1;
            result = end - start > result ? end - start: result;
        }
        return result;
    }
}