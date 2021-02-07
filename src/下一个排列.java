import java.util.Arrays;

public class 下一个排列 {
    public static void main(String[] args){
        Solution20 s = new Solution20();
        s.nextPermutation(new int[]{1,3,2});
    }
}

class Solution20 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0){
            return;
        }
        for (int i = nums.length-1; i >= 0; i--){
            for (int j = nums.length-1; j > i; j--){
                if (nums[i] < nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    Arrays.sort(nums,i+1,nums.length);
                    return;
                }
            }
        }
        for (int x = 0, y = nums.length-1; x < y; x++, y--){
            int temp1 = nums[y];
            nums[y] = nums[x];
            nums[x] = temp1;
        }

    }
}