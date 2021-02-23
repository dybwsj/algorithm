public class P674_最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int max = 1;
        int temp = 1;
        for(int i = 1; i < length; i++) {
            if(nums[i] > nums[i-1]) {
                temp++;
                max = Math.max(max, temp);
            } else {
                temp = 1;
            }
        }
        return max;
    }
}
