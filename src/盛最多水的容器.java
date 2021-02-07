public class 盛最多水的容器 {
    public static void main(String[] args){
        Solution14 s = new Solution14();
        int[] a = {1};
        s.maxArea(a);
    }
}

class Solution14 {
    public int maxArea(int[] height) {
        int start = 0;
        int len = height.length;
        if(len < 2){
            return 0;
        }
        int end = len - 1;
        int result = 0;

        len = len-1;

        while(start < end){
            int min = Math.min(height[start], height[end]);
            result = min * len > result ? min * len : result;
            if(height[start] < height[end]){
                start++;
            } else {
                end--;
            }
            len--;
        }
        return result;
    }
}