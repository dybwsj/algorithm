import java.util.ArrayList;
import java.util.List;

public class P448_找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
        ThreadLocal
    }
}
