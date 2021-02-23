import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: duyubo
 * @date: 2021年01月28日, 0028 08:48
 * @description:  前缀和
 */
public class P724_寻找数组的中心索引 {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * left + nums[i] == total) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
