/**
 * @author: duyubo
 * @date: 2021年02月07日, 0007 09:58
 * @description: 贪心
 */
public class P665_非递减数组 {
    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        int num = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                num++;
                // 最多修改一个数字
                if (num > 1) return false;
                // 将 i+1 修改为 i 或者将 i 修改为 i+1，后者可能会出现 i+1 是小于 i-1 的，例如 5 9 2 10 11， 2 小于 5，将 9 修改为 2 会导致 i-1 到 i 变为递减
                // 要么判断一下大小关系在进行修改，要么直接将 i+1 的值变为 i
                if (i > 0) {
                    if (nums[i+1] < nums[i-1]) {
                        nums[i+1] = nums[i];
                    // 这个 else 语句可以不要
                    } else {
                        nums[i] = nums[i+1];
                    }
                }
            }
        }
        return true;
    }
}
