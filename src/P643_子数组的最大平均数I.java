import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author: duyubo
 * @date: 2021年02月04日, 0004 09:08
 * @description: 滑动窗口
 */
public class P643_子数组的最大平均数I {
    public static void main(String[] args) {
        P643_子数组的最大平均数I s = new P643_子数组的最大平均数I();
        s.findMaxAverage(new int[]{-1},1);
    }
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        // 先算出初始窗口大小，然后在下一个窗口中减去移除出去的值，加上新增的值
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}
