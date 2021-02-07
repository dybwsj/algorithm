import java.util.Arrays;

public class 最大子序和 {
    public static void main(String[] args){
        Solution19 s = new Solution19();
        System.out.println(s.maxSubArray(new int[]{1,2}));
    }
}

class Solution19 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int total = nums[0];
        int max = total;
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            memo[i] = Math.max(memo[i-1]+nums[i],nums[i]);
            max = Math.max(memo[i],max);
            System.out.println(Arrays.toString(memo));
        }
        return max;
    }
}
