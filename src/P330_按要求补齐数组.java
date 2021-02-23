/**
 * @author: duyubo
 * @date: 2020年12月29日, 0029 17:25
 * @description:  数学   到 x 的值能覆盖到 2x
 */
public class P330_按要求补齐数组 {
    class Solution {
        public int minPatches(int[] nums, int n) {
            int patches = 0;
            long x = 1;
            int length = nums.length, index = 0;
            while (x <= n) {
                if (index < length && nums[index] <= x) {
                    x += nums[index];
                    index++;
                } else {
                    x *= 2;
                    patches++;
                }
            }
            return patches;
        }
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-by-leetcode-solu-klp1/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
