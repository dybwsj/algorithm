import java.util.Arrays;

/**
 * @author: duyubo
 * @date: 2021年01月20日, 0020 08:51
 * @description:
 */
public class P628_三个数的最大乘积 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}
